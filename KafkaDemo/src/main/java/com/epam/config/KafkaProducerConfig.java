package com.epam.config;

//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

//Create java class named “SimpleProducer”
public class KafkaProducerConfig {
 
 public static Producer produce(){
      
    //Assign topicName to string variable
    String topicName = "employee";
    
    // create instance for properties to access producer configs   
    Properties props = new Properties();
    
    //Assign localhost id
    props.put("bootstrap.servers", "localhost:9092");
    
    //Set acknowledgements for producer requests.      
    props.put("acks", "all");
    
    //If the request fails, the producer can automatically retry,
    props.put("retries", 0);
    
    //Specify buffer size in config
    props.put("batch.size", 16384);
    
    //Reduce the no of requests less than 0   
    props.put("linger.ms", 1);
    
    //The buffer.memory controls the total amount of memory available to the producer for buffering.   
    props.put("buffer.memory", 33554432);
    
    props.put("key.serializer", StringSerializer.class);
       
    props.put("value.serializer", StringSerializer.class);
    
    Producer<String, String> producer = new KafkaProducer
       <>(props);
          
    for(int i = 0; i < 10; i++)
       producer.send(new ProducerRecord<>(topicName 
          ,"message"+Integer.toString(i)));
             System.out.println("Message sent successfully");
             producer.close();
			return producer;
 }
}