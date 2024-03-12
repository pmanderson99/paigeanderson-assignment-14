package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChannelService channelService;
	
	public List<Message> findAll(){
		return messageRepo.findAll();
	}
	
	
	public void saveMessage(Message message) {
		messageRepo.save(message);
	}
	
	public List<Message> getMessagesByChannel(String channelName) {
		Channel channel = channelService.findByChannelName(channelName);
		return messageRepo.findByChannel(channel);
	}
}