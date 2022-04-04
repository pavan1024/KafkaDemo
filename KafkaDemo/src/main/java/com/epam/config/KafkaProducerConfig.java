package com.epam.config;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerConfig {

	public static Producer produce() {

		String topicName = "employee";

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", StringSerializer.class);
		props.put("value.serializer", StringSerializer.class);

		Producer<String, String> producer = new KafkaProducer<>(props);

		return producer;
	}
}
