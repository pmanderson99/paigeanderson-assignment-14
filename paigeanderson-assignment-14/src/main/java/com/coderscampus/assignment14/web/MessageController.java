package com.coderscampus.assignment14.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.coderscampus.assignment14.dto.MessageDTO;
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
	public void createMessage(@RequestBody MessageDTO message) {
		messageService.createMessage(message);
	
	}
	
	@GetMapping("/channels/{channelId}/getMessages")
	@ResponseBody
	public List<MessageDTO> getUpdatedMessages(@PathVariable Long channelId) {
		return messageService.findMessagesByChannelId(channelId);

	}
	 
	
}
