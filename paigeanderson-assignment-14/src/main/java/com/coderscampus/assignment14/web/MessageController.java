package com.coderscampus.assignment14.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
//import com.coderscampus.assignment14.domain.User;
//import com.coderscampus.assignment14.service.ChannelService;
//import com.coderscampus.assignment14.dto.MessageDto;
//import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	private final MessageService messageService;
	

	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
		
	}
	
	
	@PostMapping("/channels/{channelId}/createMessage")
	@ResponseBody
	private Message createMessage(@RequestBody Message message) {
		messageService.save(message);
		return message;
	}
	
	@GetMapping("/channels/{channelId}/getMessages")
	@ResponseBody
	public List<Message> getUpdatedMessages(@PathVariable Long channelId) {
		return messageService.findMessagesByChannelId(channelId);

	}
	 
	
}
