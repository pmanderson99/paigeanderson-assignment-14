package com.coderscampus.assignment14.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
//import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	ChannelRepository channelRepo;
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createNewChannel(String channelName) {
		Channel channel = new Channel();
		channel.setChannelName(channelName);
		return channelRepo.save(channel);
		
	}
	
	public Channel findByChannelName(String channelName) {
		return channelRepo.findByChannelName(channelName);
	}
	
	public Channel findByChannelId(Long channelId) {
		return channelRepo.findById(channelId).orElse(null);
	}
	
	public Channel saveChannel(Channel channel) {
		return channelRepo.save(channel);
	}
	
	
}
