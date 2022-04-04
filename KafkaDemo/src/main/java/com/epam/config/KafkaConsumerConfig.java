package com.epam.config;

import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaConsumerConfig {
   public static void main(String[] args) throws Exception {

      String topicName = "employee";
      Properties props = new Properties();
      
      props.put("bootstrap.servers", "localhost:9092");
      props.put("group.id", "test");
      props.put("enable.auto.commit", "true");
      props.put("auto.commit.interval.ms", "1000");
      props.put("session.timeout.ms", "30000");
      props.put("key.deserializer", StringDeserializer.class);
      props.put("value.deserializer", StringDeserializer.class);
      KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
      
      consumer.subscribe(Arrays.asList(topicName));
      
      System.out.println("Subscribed to topic " + topicName);
      int i = 0;
      
      while (true) {
         ConsumerRecords<String, String> records = consumer.poll(100);
         for (ConsumerRecord<String, String> record : records) {
             System.out.printf("offset = %d, key = %s, value = %s\n", 
                record.offset(), record.key(), record.value());
             i++;
          
         }
         if(i>=10) {
        	 break;
         }
         
         
      }
         
      
      
   }
   
   
   
   
   
   
   
   
   
   
   
   
}
