package com.askme.questionsservice.services;

import java.sql.Timestamp;

import java.time.Instant;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.askme.questionsservice.clients.AnswerExchangeClient;
import com.askme.questionsservice.dto.AnswerDto;
import com.askme.questionsservice.dto.QuestionDto;
import com.askme.questionsservice.entities.Question;
import com.askme.questionsservice.exceptions.QuestionNotFoundException;
import com.askme.questionsservice.mapper.Mapper;
import com.askme.questionsservice.repositories.QuestionsRepository;

@Service
public class QuestionsService {

	@Autowired
	private QuestionsRepository questionsRepository;

	@Autowired
	private AnswerExchangeClient answersExchangeClient;

	public QuestionDto save(QuestionDto questionDto) {
		questionDto.setTimestamp(Timestamp.from(Instant.now()));
		return Mapper.toDto(questionsRepository.save(Mapper.toEntity(questionDto)));
	}

	public List<QuestionDto> findAll() {
		List<QuestionDto> questions = Mapper.toDtoList(questionsRepository.findAll());
		setAssociatedAnswers(questions);
		return questions;
	}

	private void setAssociatedAnswers(List<QuestionDto> questions) {
		ResponseEntity<List<AnswerDto>> answers = answersExchangeClient.getAnswers();
		for (QuestionDto question : questions) {
			List<AnswerDto> currentAnswers = answers.getBody().stream()
					.filter(a -> a.getQuestionId() == question.getQuestionId()).toList();
			question.setAnswers(currentAnswers);
		}
	}

	public QuestionDto findById(int questionId) {
		Optional<Question> questionOptional = questionsRepository.findById(questionId);
		return Mapper.toDto(questionOptional.orElseThrow(
				() -> new QuestionNotFoundException("Question with questionId : " + questionId + " Not Found")));
	}

	public String delete(int questionId) {
		findById(questionId);
		questionsRepository.deleteById(questionId);
		deleteAssociatedAnswers(questionId);
		return "Question Deleted Successfully";
	}

	private void deleteAssociatedAnswers(int questionId) {
		ResponseEntity<List<AnswerDto>> answers = answersExchangeClient.getAnswers();
		for (AnswerDto answer : answers.getBody()) {
			if (questionId == answer.getQuestionId()) {
				answersExchangeClient.deleteAnswer(answer.getAnswerId().intValue());
			}
		}
	}

	public QuestionDto update(QuestionDto questionDto, int questionId) {
		findById(questionId);
		return Mapper.toDto(questionsRepository.save(Mapper.toEntity(questionDto)));
	}
}
