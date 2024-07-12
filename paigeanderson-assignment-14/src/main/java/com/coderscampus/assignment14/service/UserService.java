package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User createUser(String userName) {
		User newUser = new User();
		newUser.setUserName(userName);
		
		return userRepo.save(newUser);
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User findById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
		
	}
	
	
}
