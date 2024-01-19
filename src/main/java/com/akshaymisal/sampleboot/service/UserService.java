package com.akshaymisal.sampleboot.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.akshaymisal.sampleboot.dto.UserDTO;
import com.akshaymisal.sampleboot.entity.User;
import com.akshaymisal.sampleboot.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
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
	
	public List<UserDTO> getAllUsers() {
		List<User> allUser = userRepository.findAll();
		List<UserDTO> users = allUser.stream().map( user-> toUserDto(user)).collect( Collectors.toList());
		return users;
	}
	
	public UserDTO getById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isEmpty()) {
			return toUserDto(user.get());
		}
		return null;
	}
	
	public UserDTO createUser(UserDTO userToCreate) {
		User user = toUser(new User(), userToCreate);
		User savedUser = userRepository.save(user);
		return toUserDto(savedUser);
	}
	
	public UserDTO updateUser(Integer userId, UserDTO userToCreate) {
		Optional<User> userToUpdate = userRepository.findById(userId);
		if(userToUpdate.isEmpty()) {
			throw new RuntimeException("User not found with user id: "+ userId);
		}
		User user = toUser(userToUpdate.get(), userToCreate);
		User savedUser = userRepository.save(user);
		return toUserDto(savedUser);
	}
	
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
	
	private User toUser(User user, UserDTO userDTO) {
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setUserSSOKey(userDTO.getUserSSOKey());
		user.setEmail(userDTO.getEmail());
		return user;
	}
	
	private UserDTO toUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setUsername(user.getUsername());
		userDTO.setUserSSOKey(user.getUserSSOKey());
		userDTO.setEmail(user.getEmail());
		userDTO.setId(user.getId());
		userDTO.setUpdatedBy(user.getUpdatedBy());
		userDTO.setUpdatedAt(user.getUpdatedAt());
		userDTO.setCreatedBy(user.getCreatedBy());
		userDTO.setCreatedAt(user.getCreatedAt());
		return userDTO;
	}
	
}
