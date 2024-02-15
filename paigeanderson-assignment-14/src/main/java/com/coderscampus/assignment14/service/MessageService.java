package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Message;

import com.coderscampus.assignment14.repository.MessageRepository;


@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	public List<Message> findAll(){
		return messageRepo.findAll();
	}
	
	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

}
