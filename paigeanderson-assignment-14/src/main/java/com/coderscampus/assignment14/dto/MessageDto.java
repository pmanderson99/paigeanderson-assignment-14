package com.coderscampus.assignment14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
	
	@JsonProperty("message")
	private String message;
	@JsonProperty("userId")
	private Long userId;
	@JsonProperty("channelId")
	private Long channelId;
	@JsonProperty("username")
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}	
}
