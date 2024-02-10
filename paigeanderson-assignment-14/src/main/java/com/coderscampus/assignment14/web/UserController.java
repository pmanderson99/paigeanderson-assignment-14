package com.coderscampus.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.User;
//import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.UserService;

public class UserController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/welcome/createUser")
	@ResponseBody
	public User createUser(@RequestBody String username) {
		return userService.createUser(username);
	}

}
