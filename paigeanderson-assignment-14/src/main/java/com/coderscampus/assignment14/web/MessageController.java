package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.dto.MessageDto;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class MessageController {
	
	private final MessageService messageService;

	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	@ResponseBody
	@PostMapping("/sentMessages/{channelId}")
	private void sentMessage(@RequestBody MessageDto messageDto, @PathVariable Long channelId) {
		MessageDto msgDto = new MessageDto();
		System.out.println(messageDto.getChannelId());
		msgDto.setChannelId(messageDto.getChannelId());
		msgDto.setMessage(messageDto.getMessage());
		msgDto.setUserId(messageDto.getUserId());
		messageService.createMessage(messageDto, channelId);
	}
	
	@ResponseBody
	@PostMapping("/getMessages/{channelId}") 
	private List<MessageDto> getMessages(@PathVariable Long channelId){
		return messageService.getMessageByChannelId(channelId);
	}

}
