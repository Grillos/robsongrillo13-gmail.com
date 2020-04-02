package com.spring.amqp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.amqp.domain.User;
import com.spring.amqp.service.UserService;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	 
    
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
    	userService.send(user);
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
