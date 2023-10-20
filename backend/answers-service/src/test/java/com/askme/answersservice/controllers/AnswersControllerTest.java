package com.askme.answersservice.controllers;

import static org.mockito.Mockito.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.askme.answersservice.dto.AnswerDto;
import com.askme.answersservice.services.AnswersService;

@WebMvcTest(AnswersController.class)
public class AnswersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AnswersService answersService;
	
	private AnswerDto answerDto;
	
	@BeforeEach
	void setUp() throws Exception{
		answerDto = new AnswerDto();
		answerDto.setAnswerId(1L);
		answerDto.setAnswerContent("Sample Answer");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	

	@Test
	public void testAnswersList() throws Exception {
		List<AnswerDto> answerList = new ArrayList<>();
		answerList.add(answerDto);

		when(answersService.findAll()).thenReturn(answerList);

		mockMvc.perform(get("/answers").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].answerId").value(1L)).andExpect(jsonPath("$[0].answerContent").value("Sample Answer"));
	}

	@Test
	public void testCreateAnswer() throws Exception {

		when(answersService.save(any(AnswerDto.class))).thenReturn(answerDto);

		mockMvc.perform(
				post("/answers").contentType(MediaType.APPLICATION_JSON).content("{\"answerContent\":\"Sample Answer\"}"))
				.andExpect(status().isCreated()).andExpect(jsonPath("answerId").value(1L))
				.andExpect(jsonPath("answerContent").value("Sample Answer"));
	}

	@Test
	public void testViewAnswer() throws Exception {

		when(answersService.findById(1)).thenReturn(answerDto);

		mockMvc.perform(get("/answers/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("answerId").value(1L)).andExpect(jsonPath("answerContent").value("Sample Answer"));
	}

	@Test
	public void testUpdateAnswer() throws Exception {
		AnswerDto updatedAnswerDto = new AnswerDto();
		updatedAnswerDto.setAnswerId(1L);
		updatedAnswerDto.setAnswerContent("Updated Answer");

		when(answersService.update(any(AnswerDto.class), eq(1))).thenReturn(updatedAnswerDto);

		mockMvc.perform(
				put("/answers/1").contentType(MediaType.APPLICATION_JSON).content("{\"answerContent\":\"Updated Answer\"}"))
				.andExpect(status().isOk()).andExpect(jsonPath("answerId").value(1L))
				.andExpect(jsonPath("answerContent").value("Updated Answer"));
	}

	@Test
	public void testDeleteAnswer() throws Exception {
		when(answersService.delete(1)).thenReturn("Answer deleted successfully");

		mockMvc.perform(delete("/answers/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
}
