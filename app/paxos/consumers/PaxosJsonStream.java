/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package paxos.consumers;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.ProcessorContext;

/**
 * Demonstrates, using the high-level KStream DSL, how to implement the
 * WordCount program that computes a simple word occurrence histogram from an
 * input text.
 * <p>
 * In this example, the input stream reads from a topic named
 * "streams-plaintext-input", where the values of messages represent lines of
 * text; and the histogram output is written to topic "streams-wordcount-output"
 * where each record is an updated count of a single word.
 * <p>
 * Before running this example you must create the input topic and the output
 * topic (e.g. via {@code bin/kafka-topics.sh --create ...}), and write some
 * data to the input topic (e.g. via {@code bin/kafka-console-producer.sh}).
 * Otherwise you won't see any data arriving in the output topic.
 */
public final class PaxosJsonStream {

	final Properties props = new Properties();
	final StreamsBuilder builder = new StreamsBuilder();
	final String inputTopic = "input-paxos"; // "streams-plaintext-input";
	final KStream<String, String> sourceStream = builder.stream(inputTopic);
	final Produced<String, Long> producer = Produced.with(Serdes.String(), Serdes.Long());

	public PaxosJsonStream() {

		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

		// setting offset reset to earliest so that we can re-run the demo code with the
		// same pre-loaded data
		// Note: To re-run the demo, you need to use the offset reset tool:
		// https://cwiki.apache.org/confluence/display/KAFKA/Kafka+Streams+Application+Reset+Tool
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	}

	public void run() {

		Predicate<String, String> predicate = new Predicate<String, String>() {

			@Override
			public boolean test(String key, String value) {

				System.out.println("stream: " + key);
				return true;
			}
		};

		final KStream<String, String> filterStream = sourceStream.filter(predicate);
		final KTable<String, Long> countTable = filterStream.groupBy((key, value) -> handleValue(value)).count();

		// .flatMapValues(value -> handleValue(value))
		// .groupBy((key, value) -> value).count();

		countTable.toStream().to("streams-wordcount-output", producer);

		final KafkaStreams streams = new KafkaStreams(builder.build(), props);
		final CountDownLatch latch = new CountDownLatch(1);

		// attach shutdown handler to catch control-c
		Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
			@Override
			public void run() {
				streams.close();
				latch.countDown();
			}
		});

		try {
			streams.start();
			latch.await();
		} catch (final Throwable e) {
			System.exit(1);
		}
		System.exit(0);
	}

	private String handleValue(String value) {

		System.out.println("handlevalue: " + value);
		return value;
	}

	String stateStoreNames = "foo";

	public static void main(final String[] args) {
		PaxosJsonStream stream = new PaxosJsonStream();
		stream.run();
	}
}