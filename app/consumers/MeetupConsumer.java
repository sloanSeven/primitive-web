package consumers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MeetupConsumer {
	
	public MeetupConsumer() {
	}
/*
	private final static String TOPIC = "streams-wordcount-output";
	private final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";

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

	public static class Reservation {
		public float lat;
		public float lng;
		public long count;

		public Reservation(ConsumerRecord<String, Long> r) {
			String[] split = r.key().split(":");
			lat = Float.parseFloat(split[0]);
			lng = Float.parseFloat(split[1]);
			count = r.value();
		}

		public Reservation(long lat, long lon, long num) {
			this.lat = lat;
			this.lng = lon;
			this.count = num;
		}
	}

	public static void main(String... args) throws Exception {
		MeetupConsumer consumer = new MeetupConsumer();
		consumer.runConsumer();
	}
	*/
}

