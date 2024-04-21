package com.coderscampus.assignment14.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	private final ChannelRepository channelRepo;
	
	@Autowired
	public ChannelService(ChannelRepository channelRepo) {
		this.channelRepo = channelRepo;
	}
	
	public Channel findByChannelId(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createChannel(String channelName) {
		Channel newChannel = new Channel();
		newChannel.setChannelName(channelName);
		
		return channelRepo.save(newChannel);
	}
	
	public void save(Channel channel) {
		channelRepo.save(channel);
	}
	
	
	
}
