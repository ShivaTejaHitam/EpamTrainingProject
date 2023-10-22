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

	public AnswerDto postAnswer(AnswerDto answerDto) {
		answerDto.setTimestamp(Timestamp.from(Instant.now()));
		return Mapper.toDto(answersRepository.save(Mapper.toEntity(answerDto)));
	}

	public List<AnswerDto> getAllAnswers() {

		List<AnswerDto> answers = Mapper.toDtoList(answersRepository.findAll());
		setAssociatedComments(answers);
		setAssociatedLikes(answers);
		return answers;
	}

	private void setAssociatedComments(List<AnswerDto> answers) {
		ResponseEntity<List<CommentDto>> comments = commentExchangeClient.getComments();
		for (AnswerDto answer : answers) {
			List<CommentDto> currentComments = comments.getBody().stream()
					.filter(c -> c.getAnswerId() == answer.getAnswerId()).toList();
			answer.setComments(currentComments);
		}
	}

	private void setAssociatedLikes(List<AnswerDto> answers) {
		ResponseEntity<List<LikeDto>> likes = likeExchangeClient.getLikes();
		for (AnswerDto answer : answers) {
			List<LikeDto> currentLikes = likes.getBody().stream().filter(l -> l.getAnswerId() == answer.getAnswerId())
					.toList();
			answer.setLikes(currentLikes);
		}
	}

	public AnswerDto getAnswerById(int answerId) {
		Optional<Answer> answerOptional = answersRepository.findById(answerId);
		return Mapper.toDto(answerOptional
				.orElseThrow(() -> new AnswerNotFoundException("Answer with answerId : " + answerId + " Not Found.")));
	}

	public AnswerDto updateAnswer(AnswerDto answerDto, int answerId) {
		Answer answer = Mapper.toEntity(getAnswerById(answerId));
		answer.setAnswerContent(answerDto.getAnswerContent());
		answer.setTimestamp(Timestamp.from(Instant.now()));
		return Mapper.toDto(answersRepository.save(answer));
	}

	public String deleteAnswer(int answerId) {
		getAnswerById(answerId);
		answersRepository.deleteById(answerId);
		deleteAssociatedComments(answerId);
		deleteAssociatedLikes(answerId);
		return "Answer Deleted Successfully";
	}

	private void deleteAssociatedComments(int answerId) {
		ResponseEntity<List<CommentDto>> comments = commentExchangeClient.getComments();
		for (CommentDto comment : comments.getBody()) {
			if (answerId == comment.getAnswerId()) {
				commentExchangeClient.deleteComment(comment.getCommentId().intValue());
			}
		}
	}

	private void deleteAssociatedLikes(int answerId) {
		ResponseEntity<List<LikeDto>> likes = likeExchangeClient.getLikes();
		for (LikeDto like : likes.getBody()) {
			if (answerId == like.getAnswerId()) {
				likeExchangeClient.dislikeAnswer(like.getLikeId().intValue());
			}
		}
	}

}
