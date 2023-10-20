package com.askme.likesservice.mapper;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.askme.likesservice.dto.LikeDto;
import com.askme.likesservice.entities.Like;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();
	
	public static Like toEntity(LikeDto likeDto) {
		return mapper.map(likeDto, Like.class);
	}
	
	public static LikeDto toDto(Like like) {
		return mapper.map(like, LikeDto.class);
	}
	
	public static List<Like> toEntityList(List<LikeDto> likes){
		return likes.stream().map(q -> mapper.map(q,Like.class)).toList();
	}
	
	public static List<LikeDto> toDtoList(List<Like> likes){
		return likes.stream().map(b -> mapper.map(b,LikeDto.class)).toList();
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
