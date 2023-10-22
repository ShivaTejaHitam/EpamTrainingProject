package com.askme.questionsservice.controllers;

import com.askme.questionsservice.dto.QuestionDto;


import com.askme.questionsservice.services.QuestionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionsControllerTest {

    @InjectMocks
    private QuestionsController questionsController;

    @Mock
    private QuestionsService questionsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostQuestion() {
        QuestionDto questionDto = new QuestionDto();
        Mockito.when(questionsService.postQuestion(questionDto)).thenReturn(questionDto);

        ResponseEntity<QuestionDto> response = questionsController.postQuestion(questionDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(questionDto, response.getBody());
    }

    @Test
    public void testGetAllQuestions() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        Mockito.when(questionsService.getAllQuestions()).thenReturn(questionDtoList);

        ResponseEntity<List<QuestionDto> > response = questionsController.getAllQuestions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(questionDtoList, response.getBody());
    }

    @Test
    public void testGetQuestionById() {
        int questionId = 1;
        QuestionDto questionDto = new QuestionDto();
        Mockito.when(questionsService.getQuestionById(questionId)).thenReturn(questionDto);

        ResponseEntity<QuestionDto> response = questionsController.getQuestionById(questionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(questionDto, response.getBody());
    }

    @Test
    public void testUpdateQuestion() {
        int questionId = 1;
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionContent("Sample Question");
        Mockito.when(questionsService.updateQuestion(questionDto, questionId)).thenReturn(questionDto);

        ResponseEntity<QuestionDto> response = questionsController.updateQuestion(questionId, questionDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(questionDto, response.getBody());
    }

    @Test
    public void testDeleteQuestion() {
        int questionId = 1;
        Mockito.when(questionsService.deleteQuestion(questionId)).thenReturn("Question deleted successfully");

        ResponseEntity<String> response = questionsController.deleteQuestion(questionId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Question deleted successfully", response.getBody());
    }
}
