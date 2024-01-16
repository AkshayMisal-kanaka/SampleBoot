package com.akshaymisal.sampleboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akshaymisal.sampleboot.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WelcomeController {

	UserService userService;
	
	
	@GetMapping("/")
	String welcome(){
		return this.userService.getMessage();
	}
	
	@GetMapping("/{name}")
	String message(@PathVariable("name") String  name){
		return this.userService.getMessageWithName(name);
	}
}
