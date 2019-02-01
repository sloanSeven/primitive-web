package shared.consumers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SharedConsumer {
	
	public final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";
	final public StreamsBuilder builder = new StreamsBuilder();
	
	public SharedConsumer() {
	}
	
	public Consumer<String, String> createConsumer(String topic) {

		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer2");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);

		// Create the consumer using props.
		final Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		// Subscribe to the topic.
		consumer.subscribe(Collections.singletonList(topic));
		return consumer;
	}
	

	public static Producer<String, String> createProducer() {
		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "primitive-producer");
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<>(props);
	}
	
	public KafkaStreams createStreams(String inputTopic) {
		final Properties props = new Properties();

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
		

		final KafkaStreams streams = new KafkaStreams(builder.build(), props);
		return streams;

	}
/*
	private final static String TOPIC = "streams-wordcount-output";

	final Consumer<String, Long> consumer = createConsumer();
	ObjectMapper objectMapper = new ObjectMapper();

	public MeetupConsumer() {

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);

		consumer.poll(2);
		consumer.poll(2);

		List<PartitionInfo> infoList = consumer.partitionsFor(TOPIC);
		List<TopicPartition> topicPartitions = new ArrayList<TopicPartition>();
		for (PartitionInfo info : infoList) {
			topicPartitions.add(new TopicPartition(info.topic(), info.partition()));
		}
		consumer.seekToBeginning(topicPartitions);

	}

	private static Consumer<String, Long> createConsumer() {

		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);

		// Create the consumer using props.
		final Consumer<String, Long> consumer = new KafkaConsumer<String, Long>(props);

		// Subscribe to the topic.
		consumer.subscribe(Collections.singletonList(TOPIC));
		return consumer;
	}

	int count = 0;

	String runConsumer() { // throws InterruptedException {
		// should use thread pool
		synchronized (this.consumer) {

			final ArrayList<Reservation> list = new ArrayList<>();
			final int giveUp = 100;
			int noRecordsCount = 0;
			final ConsumerRecords<String, Long> consumerRecords = consumer.poll(5);

			if (consumerRecords.count() == 0) {
				noRecordsCount++;
			}

			consumerRecords.forEach(record -> {
				count++;

				System.out.println("Consumer Record:\n\t" + " " + record.key() + " " + record.value() + " "
						+ record.partition() + " " + record.offset());
				list.add(new Reservation(record));
			});

			consumer.commitAsync();

			System.out.println("fetched " + list.size());
			try {
				return objectMapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				return "[]";
			}
		}
	}


	public static void main(String... args) throws Exception {
		MeetupConsumer consumer = new MeetupConsumer();
		consumer.runConsumer();
	}
	*/
}

