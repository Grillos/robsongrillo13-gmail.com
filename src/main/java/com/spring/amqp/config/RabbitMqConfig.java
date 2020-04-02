package com.spring.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	
	@Value("${queue.user.name}")
	private String userQueue;
	
	@Bean
	public Queue queue() {
		return new Queue(userQueue, true);
	}

}
