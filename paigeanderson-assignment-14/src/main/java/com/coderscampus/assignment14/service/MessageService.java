package com.coderscampus.assignment14.service;

//import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
//import com.coderscampus.assignment14.domain.User;
//import com.coderscampus.assignment14.dto.MessageDto;
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

	public Message save(Message message, Channel channel) {
		channel = channelService.findById(channel.getChannelId());
		return messageRepo.save(message);
	}

	
	public List<Message> findMessagesByChannelId(Long channelId) {
        return messageRepo.findByChannelId(channelId);
    }

	
}