package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/channels/{channelId}/messages")
	@ResponseBody
	public List<Message> getMessages() {
		return messageService.findAll();
	}

	@PostMapping("/channels/{channelId}/createMessage")
	public Message createMessage(@RequestBody Message message) {
		messageService.saveMessage(message);
		return message;
	}

}
