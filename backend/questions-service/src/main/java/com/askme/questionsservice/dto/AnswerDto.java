package com.askme.questionsservice.dto;

import java.sql.Timestamp;

import java.util.List;

public class AnswerDto {
	private Long answerId;
	private String answerContent;
	private Long questionId;
	private String userEmail;
	private Timestamp timestamp;
	private List<LikeDto> likes;
	private List<CommentDto> comments;

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public List<LikeDto> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeDto> likes) {
		this.likes = likes;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comment) {
		this.comments = comment;
	}

}
