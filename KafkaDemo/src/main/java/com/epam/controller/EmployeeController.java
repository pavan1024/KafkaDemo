package com.epam.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.config.KafkaProducerConfig;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@PostMapping("/{message}")
	public String createMessage(@PathVariable String message) {
		KafkaProducerConfig.produce().send(new ProducerRecord<>("employee",message));
		return "Published Successfully";
	}
	
	@KafkaListener(topics = "employee",groupId = "group1")
	public void getMessages(String message) {
		System.out.println(message);
	}

}
