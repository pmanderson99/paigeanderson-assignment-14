package com.coderscampus.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "channels")
public class Channel {

	private Long channelId;
	private String channelName;
	private List<User> users = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getName() {
		return channelName;
	}
	public void setName(String name) {
		this.channelName = name;
	}
	@ManyToMany(mappedBy = "channels", cascade = CascadeType.PERSIST)
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@OneToMany(mappedBy = "channel", cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", users=" + users + ", messages="
				+ messages + "]";
	}
	
	
}
