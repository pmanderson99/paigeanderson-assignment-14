package com.coderscampus.assignment14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	ChannelRepository channelRepo;
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel findByChannelId(Long channelId) {
		Optional<Channel> channelOpt = channelRepo.findById(channelId);
		return channelOpt.orElse(new Channel());
	}
	
	public Channel saveChannel(Channel channel) {
		return channelRepo.save(channel);
	}

}
