package com.revature.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.revature.dtos.RegisterRequest;
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.repo.UserRepo;

@Service
public class UserService {
	
	private final UserRepo uRepo;
	
	public UserService(UserRepo uRepo) {
		this.uRepo = uRepo;
	}
	
	public Optional<User> findByCredentials (String username, String password){
		
		Optional<User> optionalUser = uRepo.findByUsernameAndPassword(username, password);
		
		if (optionalUser.isPresent()) {
			return optionalUser;
		} else {
			throw new RuntimeException(String.format("User not found", username));
		}
	}
	
	public User save(User user) {
		return uRepo.save(user);
	}
	
	public Optional<User> findById(int id){
        Optional<User> optionalUser = uRepo.findById(id);
		
		if (optionalUser.isPresent()) {
			return optionalUser;
		} else {
			throw new RuntimeException(String.format("User not found", id));
		}
	}
	
	public Optional<User> findByUsernameAndPassword(String username, String password){
        Optional<User> optionalUser = uRepo.findByUsernameAndPassword(username, password);
		
		if (optionalUser.isPresent()) {
			return optionalUser;
		} else {
			throw new RuntimeException(String.format("User not found", username));
		}
	}
	
	public Optional<User> findByUsername(String username){
        Optional<User> optionalUser = uRepo.findByUsername(username);
		
		if (optionalUser.isPresent()) {
			return optionalUser;
		} else {
			throw new RuntimeException(String.format("User not found", username));
		}
	}
	
	public User register(RegisterRequest registerRequest) {
		User user = new User(
				registerRequest.getUsername(),
				registerRequest.getPassword(),
				0);
		
		Optional<User> optionalUser = uRepo.findAll().stream()
				.filter(r -> r.getUsername() == registerRequest.getUsername())
				.findFirst();
		if (optionalUser.isPresent()) {
			throw new RuntimeException("This Username already exists");
		}
		uRepo.save(user);
		
		return user;
	}
	

}
