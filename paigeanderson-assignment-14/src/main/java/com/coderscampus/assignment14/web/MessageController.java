package com.coderscampus.assignment14.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	private final MessageService messageService;
	

	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
		
	}
	
	
	/*
	 * @PostMapping("/channels/{channelId}/createMessage")
	 * @ResponseBody 
	 * private Message createMessage(@RequestBody Message message) {
	 * messageService.save(message); 
	 * return message; }
	 */
	
	@PostMapping("/channels/{channelId}/createMessage")
	@ResponseBody
	private ResponseEntity<Message> createMessage(@RequestBody Message message) {
		messageService.save(message);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
		//return message;
	}
	
	@GetMapping("/channels/{channelId}/getMessages")
	@ResponseBody
	public List<Message> getUpdatedMessages(@PathVariable Long channelId) {
		return messageService.findMessagesByChannelId(channelId);

	}
	 
	
}
