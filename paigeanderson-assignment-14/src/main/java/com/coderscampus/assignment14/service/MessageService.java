package com.coderscampus.assignment14.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.MessageRepository;


@Service
public class MessageService {
	
	private final MessageRepository messageRepo;
	private final ChannelService channelService;
	
	
	
	@Autowired
	public MessageService(MessageRepository messageRepo, ChannelService channelService) {
		this.messageRepo = messageRepo;
		this.channelService = channelService;
		
	}

	public Message save(Message message) {
		return messageRepo.save(message);
	}

	
	public List<Message> findMessagesByChannelId(Long channelId) {
		channelService.findById(channelId);
		return messageRepo.findByChannelId(channelId);
    }

	
}