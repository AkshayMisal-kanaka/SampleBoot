package com.akshaymisal.sampleboot.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getMessage() {
		return "Hello !!!";
	}

	public String getMessageWithName(String name) {
		return "Your name is " + name + "!!!";
	}
}
