package com.coderscampus.assignment14.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User createUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		return userRepo.save(user);
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public Optional<User> findByUserId(Long userId) {
		return userRepo.findById(userId);
	}
	
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	
}
