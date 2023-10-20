package com.askme.questionsservice.mapper;

import java.io.IOException;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.askme.questionsservice.dto.QuestionDto;
import com.askme.questionsservice.entities.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();
	
	public static Question toEntity(QuestionDto questionDto) {
		return mapper.map(questionDto, Question.class);
	}
	
	public static QuestionDto toDto(Question question) {
		return mapper.map(question, QuestionDto.class);
	}
	
	public static List<Question> toEntityList(List<QuestionDto> questions){
		return questions.stream().map(q -> mapper.map(q,Question.class)).toList();
	}
	
	public static List<QuestionDto> toDtoList(List<Question> questions){
		return questions.stream().map(b -> mapper.map(b,QuestionDto.class)).toList();
	}
	
	public static String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	}
	
	public static <T> T mapFromJson(String json, Class<T> className)
	      throws  IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, className); 
	}

}
