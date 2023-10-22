package com.askme.questionsservice.services;


import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.askme.questionsservice.clients.AnswerExchangeClient;
import com.askme.questionsservice.dto.AnswerDto;
import com.askme.questionsservice.dto.QuestionDto;
import com.askme.questionsservice.entities.Question;
import com.askme.questionsservice.mapper.Mapper;
import com.askme.questionsservice.repositories.QuestionsRepository;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class QuestionsServiceTest {

	@InjectMocks
	private QuestionsService questionsService;

	@Mock
	private QuestionsRepository questionsRepository;

	@Mock
	private AnswerExchangeClient answersExchangeClient;
	
	private QuestionDto questionDto;

	@BeforeEach
	public void setUp () {
		questionDto = new QuestionDto();
		questionDto.setQuestionId(1L);
		questionDto.setQuestionContent("Test Question");
		
	}

	@Test
	public void testPostQuestion() {
		

		Question questionEntity = Mapper.toEntity(questionDto);

		when(questionsRepository.save(any(Question.class))).thenReturn(questionEntity);

		QuestionDto savedQuestion = questionsService.postQuestion(questionDto);

		assertEquals(questionDto.getQuestionContent(), savedQuestion.getQuestionContent());
	}

	@Test
	public void testGetAllQuestions() {
		
		List<Question> questionEntities = new ArrayList<>();
		questionEntities.add(Mapper.toEntity(questionDto));

		when(questionsRepository.findAll()).thenReturn(questionEntities);

		AnswerDto answerDto = new AnswerDto();
		answerDto.setQuestionId(1L);
		answerDto.setAnswerContent("Test answer");

		List<AnswerDto> answerList = new ArrayList<>();
		answerList.add(answerDto);

		ResponseEntity<List<AnswerDto>> answerResponse = new ResponseEntity<>(answerList, HttpStatus.OK);
		when(answersExchangeClient.getAnswers()).thenReturn(answerResponse);

		List<QuestionDto> questions = questionsService.getAllQuestions();

		assertEquals(1, questions.size());
		assertEquals(1, questions.get(0).getAnswers().size());
	}

	@Test
	public void testGetQuestionById() {
		
		Question questionEntity = Mapper.toEntity(questionDto);

		when(questionsRepository.findById(1)).thenReturn(Optional.of(questionEntity));

		QuestionDto foundQuestion = questionsService.getQuestionById(1);

		assertEquals(questionDto.getQuestionContent(), foundQuestion.getQuestionContent());
	}

	
	@Test
	public void testDeleteQuestion() {
		
		AnswerDto answerDto = new AnswerDto();
		answerDto.setAnswerId(1L);
		answerDto.setQuestionId(1L);
		answerDto.setAnswerContent("Test answer");
		List<AnswerDto> answerList = new ArrayList<>();
		answerList.add(answerDto);
		ResponseEntity<List<AnswerDto>> answerResponse = new ResponseEntity<>(answerList, HttpStatus.OK);
		
		when(questionsRepository.findById(1)).thenReturn(Optional.of(Mapper.toEntity(questionDto)));
		when(answersExchangeClient.getAnswers()).thenReturn(answerResponse);
		when(answersExchangeClient.deleteAnswer(1)).thenReturn(new ResponseEntity<>("Answer Deleted Successfully", HttpStatus.NO_CONTENT));

		String result = questionsService.deleteQuestion(1);

		assertEquals("Question Deleted Successfully", result);
	}

	

	@Test
	public void testUpdateQuestion() {
		
		QuestionDto updatedQuestion = new QuestionDto();
		updatedQuestion.setQuestionContent("Updated Question Content");
		Question questionEntity = Mapper.toEntity(updatedQuestion);

		when(questionsRepository.findById(1)).thenReturn(Optional.of(Mapper.toEntity(questionDto)));
		when(questionsRepository.save(any(Question.class))).thenReturn(questionEntity);

		QuestionDto updatedQuestionRes = questionsService.updateQuestion(questionDto, 1);

		assertEquals(updatedQuestion.getQuestionContent(), updatedQuestionRes.getQuestionContent());
	}

}
