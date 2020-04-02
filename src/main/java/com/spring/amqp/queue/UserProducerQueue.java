package com.spring.amqp.queue;

import java.util.Random;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.amqp.domain.User;

@Component
public class UserProducerQueue {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queue;
	
	public void send(User user){
		try {
			user.setId(new Random().nextLong());
			rabbitTemplate.convertAndSend(this.queue.getName(), user.toJson());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
