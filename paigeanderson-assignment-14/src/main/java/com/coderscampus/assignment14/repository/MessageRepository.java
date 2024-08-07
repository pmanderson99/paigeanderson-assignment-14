package com.coderscampus.assignment14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query(value ="SELECT * FROM MESSAGES WHERE channel_id = ?", nativeQuery = true)
	List<Message> findByChannelId(Long channelId);
	
}