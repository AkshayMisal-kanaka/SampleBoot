package com.akshaymisal.sampleboot.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	Environment environment;
	
	public UserService(Environment environment) {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "This is sampel boot application !!!";
	}

	public String getMessageWithName(String name) {
		return "Your name is " + name + "!!!";
	}
	
	public String getEnvironmentName() throws UnknownHostException { 
		return InetAddress.getLocalHost().getHostAddress();
	}
}
