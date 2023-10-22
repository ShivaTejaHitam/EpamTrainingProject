package com.askme.answersservice.services;

import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.askme.answersservice.clients.CommentExchangeClient;
import com.askme.answersservice.clients.LikeExchangeClient;
import com.askme.answersservice.dto.AnswerDto;
import com.askme.answersservice.dto.CommentDto;
import com.askme.answersservice.dto.LikeDto;
import com.askme.answersservice.entities.Answer;
import com.askme.answersservice.mapper.Mapper;
import com.askme.answersservice.repositories.AnswersRepository;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
public class AnswersServiceTest {

	@InjectMocks
	private AnswersService answersService;

	@Mock
	private AnswersRepository answersRepository;

	@Mock
	private CommentExchangeClient commentExchangeClient;

	@Mock
	private LikeExchangeClient likeExchangeClient;

	private AnswerDto answerDto;

	@BeforeEach
	public void setUp() {
		Mockito.reset(answersRepository, commentExchangeClient, likeExchangeClient);
		answerDto = new AnswerDto();
		answerDto.setAnswerId(1L);
	}

	@Test
	public void testPostAnswer() {

		Mockito.when(answersRepository.save(any(Answer.class))).thenReturn(Mapper.toEntity(answerDto));

		AnswerDto savedAnswer = answersService.postAnswer(answerDto);

		assertEquals(answerDto.getAnswerContent(), savedAnswer.getAnswerContent());
	}

	@Test
	public void testGetAllAnswers() {

		List<Answer> answers = new ArrayList<>();
		answers.add(Mapper.toEntity(answerDto));

		List<CommentDto> comments = new ArrayList<>();
		List<LikeDto> likes = new ArrayList<>();

		Mockito.when(answersRepository.findAll()).thenReturn(answers);
		Mockito.when(commentExchangeClient.getComments()).thenReturn(ResponseEntity.ok(comments));
		Mockito.when(likeExchangeClient.getLikes()).thenReturn(ResponseEntity.ok(likes));

		List<AnswerDto> result = answersService.getAllAnswers();

		assertEquals(1, result.size());
		assertEquals(answerDto.getAnswerContent(), result.get(0).getAnswerContent());
	}

	@Test
	public void testGetAnswerById() {

		Optional<Answer> answerOptional = Optional.of(Mapper.toEntity(answerDto));
		int answerId = 1;

		Mockito.when(answersRepository.findById(eq(answerId))).thenReturn(answerOptional);

		AnswerDto result = answersService.getAnswerById(answerId);

		assertEquals(answerDto.getAnswerContent(), result.getAnswerContent());
	}

	@Test
	public void testUpdateAnswer() {
		Long answerId = 2L;
		AnswerDto updatedAnswerDto = new AnswerDto();
		updatedAnswerDto.setAnswerId(answerId);
		Optional<Answer> answerOptional = Optional.of(Mapper.toEntity(answerDto));

		Mockito.when(answersRepository.findById(eq(1))).thenReturn(answerOptional);
		Mockito.when(answersRepository.save(any(Answer.class))).thenReturn(Mapper.toEntity(updatedAnswerDto));

		AnswerDto updatedAnswer = answersService.updateAnswer(updatedAnswerDto, 1);

		assertEquals(updatedAnswerDto.getAnswerContent(), updatedAnswer.getAnswerContent());
	}

	@Test
	public void testDeleteAnswer() {
		int answerId = 1;

		Optional<Answer> answerOptional = Optional.of(Mapper.toEntity(answerDto));
		List<CommentDto> comments = new ArrayList<>();
		List<LikeDto> likes = new ArrayList<>();

		Mockito.when(answersRepository.findById(eq(answerId))).thenReturn(answerOptional);
		Mockito.when(commentExchangeClient.getComments()).thenReturn(ResponseEntity.ok(comments));
		Mockito.when(likeExchangeClient.getLikes()).thenReturn(ResponseEntity.ok(likes));

		String result = answersService.deleteAnswer(answerId);

		assertEquals("Answer Deleted Successfully", result);
		Mockito.verify(answersRepository, Mockito.times(1)).deleteById(eq(answerId));
	}
}
