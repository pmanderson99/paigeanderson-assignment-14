package com.coderscampus.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table(name = "channels")
public class Channel {

	private Long channelId;
	private String channelName;
	private List<User> users = new ArrayList<User>();
	private List<Message> messages = new ArrayList<Message>();
	
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
