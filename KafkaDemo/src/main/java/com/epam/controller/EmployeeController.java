package com.epam.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.config.KafkaProducerConfig;
import com.epam.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@PostMapping
	public String createMessage(@RequestBody Employee employee) {
		KafkaProducerConfig.produce().send(new ProducerRecord<>("employee", employee.toString()));
		return employee.toString();
	}

	@KafkaListener(topics = "employee", groupId = "group1")
	public void getMessages(String message) {
		System.out.println(message);
	}

}
