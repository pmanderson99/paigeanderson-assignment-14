package com.coderscampus.assignment14.dto;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	
	@JsonProperty("userName")
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
	
	@Override
	public int hashCode() {
		return Objects.hash(channelId, messageText, userId);
	}
	
	@Override
	public String toString() {
		return "MessageDTO [userName=" + userName + ", messageText=" + messageText + ", channelId=" + channelId
				+ ", userId=" + userId + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		MessageDTO other = (MessageDTO) obj;
		return Objects.equals(channelId, other.channelId) && Objects.equals(messageText, other.messageText)
				&& Objects.equals(userId, other.userId);
	}

}
