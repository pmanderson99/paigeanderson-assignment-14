package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		return userRepo.save(user);
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User findByUserId(Long userId) {
		return userRepo.findByUserId(userId);
	}
	
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	public List<User> findAll(){
		List<User> findAll = userRepo.findAll();
		return findAll;
		
	}
	
}
