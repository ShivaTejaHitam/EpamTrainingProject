package com.askme.answersservice.clients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.askme.answersservice.dto.CommentDto;

import jakarta.validation.Valid;

@Component
public class CommentExchangeClientImpl implements CommentExchangeClient {

	@Override
	public ResponseEntity<CommentDto> getCommentById(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CommentDto>> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CommentDto> createComment(@Valid CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CommentDto> updateComment(int commentId, @Valid CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteComment(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
