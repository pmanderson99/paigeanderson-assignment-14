package com.coderscampus.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/welcome/createUser")
	@ResponseBody
	public User createUser(@RequestBody String userName) {
		return userService.createUser(userName);
		
	}

}
