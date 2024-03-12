package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.Message;
//import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/channels/{channelName}/messages")
	@ResponseBody
	public List<Message> getMessages(@PathVariable String channelName) {
		return messageService.getMessagesByChannel(channelName);
	}

	@PostMapping("/channels/{channelName}/createMessage")
	@ResponseBody
	public Message createMessage(@RequestBody Message message) {
		messageService.saveMessage(message);
		return message;
	}
	
}
