package com.akshaymisal.sampleboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	@GetMapping("/")
	String welcome(){
		return "Hello !!!";
	}
	
	@GetMapping("/{name}")
	String message(@PathVariable("name") String  name){
		return "Hello " + name + "!!!";
	}
}
