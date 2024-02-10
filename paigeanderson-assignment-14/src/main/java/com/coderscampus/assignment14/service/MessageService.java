package com.coderscampus.assignment14.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Message;

import com.coderscampus.assignment14.repository.MessageRepository;


@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	public List<Message> findAllByChannelId(String channelName){
		return messageRepo.findAllByChannelId(channelName);
	}

	public Message save(List<Message> Messages) {
		List<Message> savedMessages = new ArrayList<>();
		for (Message message : Messages) {
			Message savedMessage = new Message();
			savedMessages.add(message);
			savedMessages.add(savedMessage);
		}
		return (Message) savedMessages;
	}
}
