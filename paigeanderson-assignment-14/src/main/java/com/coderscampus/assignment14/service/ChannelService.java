package com.coderscampus.assignment14.service;

import java.util.List;


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
	

	public Channel findById(Long channelId) {
		return channelRepo.findById(channelId).orElse(null);
	}
	
	public Channel findByChannelName(String channelName) {
        return channelRepo.findByChannelName(channelName).orElse(null);
    }
	
	public Channel createChannel(String channelName) {
		Channel newChannel = new Channel();
		newChannel.setChannelName(channelName);
		
		return channelRepo.save(newChannel);
	}
	
	public Channel save(Channel channel) {
		return channelRepo.save(channel);
	}
	
	public List<Channel> findAll(){
		return channelRepo.findAll();
	}
	
	
}

