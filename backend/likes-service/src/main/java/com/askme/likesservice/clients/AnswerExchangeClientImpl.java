package com.askme.likesservice.clients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.askme.likesservice.dto.AnswerDto;

import jakarta.validation.Valid;

@Component
public class AnswerExchangeClientImpl implements AnswerExchangeClient{

	@Override
	public ResponseEntity<AnswerDto> getAnswerById(int answerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<AnswerDto>> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AnswerDto> createAnswer(@Valid AnswerDto answerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AnswerDto> updateAnswer(int answerId, @Valid AnswerDto answerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteAnswer(int answerId) {
		// TODO Auto-generated method stub
		return null;
	}

}