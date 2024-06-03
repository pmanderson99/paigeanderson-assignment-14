package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
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
	
	public Message save(Message message) {
		User user = userService.findById(message.getUser().getUserId());
		message.setUser(user);
		Channel channel = channelService.findByChannelName(message.getChannel().getChannelName());
		message.setChannel(channel);
		messageRepo.save(message);
		user.getMessages().add(message);
		channel.getMessages().add(message);
		return message;
	}
	
	public List<Message> findMessagesByChannel(Long channelId){
		return messageRepo.findByChannelId(channelId);
	}
}