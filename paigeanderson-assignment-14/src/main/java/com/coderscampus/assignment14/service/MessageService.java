package com.coderscampus.assignment14.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDTO;
import com.coderscampus.assignment14.repository.MessageRepository;


@Service
public class MessageService {
	
	private final MessageRepository messageRepo;
	private final ChannelService channelService;
	private final UserService userService;
	
	
	
	@Autowired
	public MessageService(MessageRepository messageRepo, ChannelService channelService, UserService userService) {
		this.messageRepo = messageRepo;
		this.channelService = channelService;
		this.userService = userService;
		
	}
	
	public void createMessage(MessageDTO message) {
		Channel channel = channelService.findById(message.getChannelId());
		Message newMessage = new Message();
		User user = userService.findById(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessageText(message.getMessageText());
		newMessage.setChannel(channel);
		messageRepo.save(newMessage);
		
	}
	
	public List<MessageDTO> findMessagesByChannelId(Long channelId) {
		List<Message> messageList = messageRepo.findByChannelId(channelId);
		List<MessageDTO> newMessages = new ArrayList<MessageDTO>();
		for(Message message : messageList) {
			MessageDTO messageDto = new MessageDTO();
			messageDto.setUserName(userService.findNameById(message.getUser().getUserId()));
			messageDto.setMessageText(message.getMessageText());
			messageDto.setChannelId(message.getChannel().getChannelId());
			messageDto.setUserId(message.getUser().getUserId());
			
			newMessages.add(messageDto);
		}
		
		return newMessages;
	}
}