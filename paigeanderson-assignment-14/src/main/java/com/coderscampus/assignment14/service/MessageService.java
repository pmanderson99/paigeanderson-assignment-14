package com.coderscampus.assignment14.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.dto.MessageDto;
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
	
	public void createMessage(MessageDto message) {
		Channel channel = channelService.findByChannelId(message.getChannelId());
		Message newMessage = new Message();
		User user = new User();
		user = userService.findByUserId(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessageText(message.getMessage());
		newMessage.setChannel(channel);
		messageRepo.save(newMessage);
		
	}

	public List<MessageDto> getMessageByChannelId(Long channelId) {
		List<Message> messageList = messageRepo.findByChannelId(channelId);
		List<MessageDto> messagesDto = new ArrayList<MessageDto>();
		for (Message message:messageList) {
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage(message.getMessageText());
			messageDto.setUserId(message.getUser().getUserId());
			messageDto.setChannelId(message.getMessageId());
			messageDto.setUserName(message.getUser().getUserName());
			messagesDto.add(messageDto);
		}
		return messagesDto;
	}
}