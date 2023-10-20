package com.askme.answersservice.services;

import java.sql.Timestamp;


import java.time.Instant;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.askme.answersservice.clients.CommentExchangeClient;
import com.askme.answersservice.clients.LikeExchangeClient;
import com.askme.answersservice.dto.AnswerDto;
import com.askme.answersservice.dto.CommentDto;
import com.askme.answersservice.dto.LikeDto;
import com.askme.answersservice.entities.Answer;
import com.askme.answersservice.exceptions.AnswerNotFoundException;
import com.askme.answersservice.mapper.Mapper;
import com.askme.answersservice.repositories.AnswersRepository;

@Service
public class AnswersService {

	@Autowired
	private AnswersRepository answersRepository;

	@Autowired
	private CommentExchangeClient commentExchangeClient;

	@Autowired
	private LikeExchangeClient likeExchangeClient;

	public AnswerDto save(AnswerDto answerDto) {
		answerDto.setTimestamp(Timestamp.from(Instant.now()));
		return Mapper.toDto(answersRepository.save(Mapper.toEntity(answerDto)));
	}

	public List<AnswerDto> findAll() {

		List<AnswerDto> answers = Mapper.toDtoList(answersRepository.findAll());
		ResponseEntity<List<CommentDto>> comments = commentExchangeClient.getComments();
		ResponseEntity<List<LikeDto>> likes = likeExchangeClient.getLikes();

		for (AnswerDto answer : answers) {
			List<CommentDto> currentComments = comments.getBody().stream()
					.filter(c -> c.getAnswerId() == answer.getAnswerId()).toList();
			List<LikeDto> currentLikes = likes.getBody().stream().filter(l -> l.getAnswerId() == answer.getAnswerId())
					.toList();
			answer.setComments(currentComments);
			answer.setLikes(currentLikes);
		}

		return answers;
	}

	public AnswerDto findById(int answerId) {
		Optional<Answer> answerOptional = answersRepository.findById(answerId);
		return Mapper.toDto(answerOptional
				.orElseThrow(() -> new AnswerNotFoundException("Answer with answerId : " + answerId + " Not Found.")));
	}
	
	public AnswerDto update(AnswerDto answerDto,int answerId) {
		findById(answerId);
		return Mapper.toDto(answersRepository.save(Mapper.toEntity(answerDto)));
	}

	public String delete(int answerId) {
		findById(answerId);
		answersRepository.deleteById(answerId);
		return "Answer Deleted Successfully";
	}

}
