package com.spring.amqp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.amqp.domain.User;
import com.spring.amqp.queue.UserProducerQueue;

@Service
public class UserService {
	
	@Autowired
	private UserProducerQueue userProducerQueue;
	
	public void send(User user) {
		userProducerQueue.send(user);
	}

}
