package com.spring.amqp.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private Long id;
	
	private String username;
	
	private String password;

	public String toJson() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
	
	public static User toObject(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, User.class);
	}
		
}
