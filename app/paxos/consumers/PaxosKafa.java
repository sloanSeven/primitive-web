package paxos.consumers;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Predicate;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Reducer;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import shared.consumers.SharedConsumer;

public class PaxosKafa extends SharedConsumer {

	private final String outputTopic = "output-paxos";
	private final String inputTopic = "input-paxos";
	String stateStoreNames = "foo";

	final Consumer<String, String> consumer = createConsumer(inputTopic);
	ObjectMapper objectMapper = new ObjectMapper();
	final Producer<String, String> webProducer = createProducer();

	final KStream<String, String> sourceStream = builder.stream(inputTopic);
	KafkaStreams streams = createStreams(inputTopic);

	// final KafkaStreams streams = createStreams(inputTopic);
	final Produced<String, String> producer = Produced.with(Serdes.String(), Serdes.String());

	public PaxosKafa() {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
		// props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	}

	public void write(String key, String value) {
		final ProducerRecord<String, String> record = new ProducerRecord<>(inputTopic, key, value);
		try {

			RecordMetadata metadata = webProducer.send(record).get();

			System.out.printf("sent record(key=%s value=%s) " + "meta(partition=%d,offset=%d)\n", record.key(),
					record.value(), metadata.partition(), metadata.offset());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
