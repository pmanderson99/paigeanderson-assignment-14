package com.coderscampus.assignment14.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired 
	private MessageService messageService;
	
	@GetMapping("/message/{channelId}")
	public List<Message> getMessages(@PathVariable Long channelId) {
		try {
			List<Message> messages = messageService.findAll();
			return messages;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); 
		}
	}
	@PostMapping("/message")
	public Message postMessage(@RequestBody Message message) {
		messageService.saveMessage(message);
		System.out.println(message);
		return message;
		
	}




}
