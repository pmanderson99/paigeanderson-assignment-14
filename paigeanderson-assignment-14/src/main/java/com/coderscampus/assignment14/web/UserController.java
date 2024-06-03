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
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/welcome/createUser")
	@ResponseBody
	public String createUser(@RequestBody String userName) {
		User user = userService.findByUserName(userName);
		user.setUserName(userName);
		user = userService.saveUser(user);
		
		return "redirect:/channels/" + user.getUserId();
	
	}

}
