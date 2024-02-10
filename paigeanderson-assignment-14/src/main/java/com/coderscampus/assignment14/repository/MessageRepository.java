package com.coderscampus.assignment14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	List<Message> findAllByChannelId(String channelName);
	
}