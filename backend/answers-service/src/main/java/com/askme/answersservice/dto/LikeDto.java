package com.askme.answersservice.dto;

public class LikeDto {
	
	private Long likeId;
	private Long answerId;
	private String userEmail;
	
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
