package com.askme.commentsservice.mapper;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.entities.Comment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();
	
	public static Comment toEntity(CommentDto commentDto) {
		return mapper.map(commentDto, Comment.class);
	}
	
	public static CommentDto toDto(Comment comment) {
		return mapper.map(comment, CommentDto.class);
	}
	
	public static List<Comment> toEntityList(List<CommentDto> comments){
		return comments.stream().map(q -> mapper.map(q,Comment.class)).toList();
	}
	
	public static List<CommentDto> toDtoList(List<Comment> comments){
		return comments.stream().map(b -> mapper.map(b,CommentDto.class)).toList();
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
