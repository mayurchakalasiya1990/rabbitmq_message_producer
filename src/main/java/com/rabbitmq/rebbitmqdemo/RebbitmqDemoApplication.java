package com.rabbitmq.rebbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RebbitmqDemoApplication implements CommandLineRunner {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RebbitmqDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MessageDetails messageDetails= new MessageDetails();
		messageDetails.setName("Mayur");
		messageDetails.setDescription("Software Engineer");
		rabbitTemplate.convertAndSend("MyTopicExchange","topic",messageDetails);
	}
}
