package com.coderscampus.assignment14.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	
	@JsonProperty("username")
	private String userName;
	@JsonProperty("messageText")
	private String messageText;
	@JsonProperty("channelId")
	private Long channelId;
	@JsonProperty("userId")
	private Long userId;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
