package com.askme.answersservice.mapper;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.askme.answersservice.dto.AnswerDto;
import com.askme.answersservice.entities.Answer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();
	
	public static Answer toEntity(AnswerDto answerDto) {
		return mapper.map(answerDto, Answer.class);
	}
	
	public static AnswerDto toDto(Answer answer) {
		return mapper.map(answer, AnswerDto.class);
	}
	
	public static List<Answer> toEntityList(List<AnswerDto> answers){
		return answers.stream().map(q -> mapper.map(q,Answer.class)).toList();
	}
	
	public static List<AnswerDto> toDtoList(List<Answer> answers){
		return answers.stream().map(b -> mapper.map(b,AnswerDto.class)).toList();
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
