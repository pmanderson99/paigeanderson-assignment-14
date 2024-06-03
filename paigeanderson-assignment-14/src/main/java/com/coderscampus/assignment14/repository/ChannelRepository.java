package com.coderscampus.assignment14.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository <Channel, Long>{
	
	Optional<Channel> findByChannelName(String channelName);
}
