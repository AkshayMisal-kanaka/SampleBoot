package com.akshaymisal.sampleboot.controller;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshaymisal.sampleboot.dto.UserDTO;
import com.akshaymisal.sampleboot.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	UserService userService;
	
	
	@GetMapping("/")
	String welcome(){
		return this.userService.getMessage();
	}
	
	@GetMapping("/{name}")
	String message(@PathVariable("name") String  name){
		return this.userService.getMessageWithName(name);
	}
	
	@GetMapping("/env")
	String getIp() throws UnknownHostException{
		return this.userService.getEnvironmentName();
	}
	
	@PostMapping("/users")
	UserDTO createUser(@RequestBody UserDTO user){
		return this.userService.createUser(user);
	}
	
	@PutMapping("/users/{id}")
	UserDTO createUser(@PathVariable("id") Integer id, @RequestBody UserDTO user){
		return this.userService.updateUser(id, user);
	}
	
	@GetMapping("/users/all")
	List<UserDTO> getAll(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	UserDTO getById(@PathVariable("id") Integer userId){
		return this.userService.getById(userId);
	}
	
	@DeleteMapping("/users/{id}")
	String deleteById(@PathVariable("id") Integer userId){
		this.userService.deleteUser(userId);
		return "User deleted successfully";
	}
}
