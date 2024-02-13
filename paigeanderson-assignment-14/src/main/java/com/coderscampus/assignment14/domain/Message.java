package com.coderscampus.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Message {
	
	private Long messageId;
	private String messageText;
	private Channel channel;
	private User user;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id")
	private List<Message> messages = new ArrayList<Message>(); 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	@ManyToOne
	@JoinColumn(name="channel_id")
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageText=" + messageText + ", channel=" + channel + ", user="
				+ user + "]";
	}
	
}
