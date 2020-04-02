package com.spring.amqp.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.spring.amqp.domain.User;

@Component
public class UserConsumerQueue {
	
	@RabbitListener(queues = {"${queue.user.name}"})
	public void get(@Payload String json) throws Exception {
		
		System.out.println("::: user :: "+ User.toObject(json));
	}

}
