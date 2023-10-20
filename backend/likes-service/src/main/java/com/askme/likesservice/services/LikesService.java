package com.askme.likesservice.services;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askme.likesservice.dto.LikeDto;
import com.askme.likesservice.mapper.Mapper;
import com.askme.likesservice.repositories.LikesRepository;

@Service
public class LikesService {
	
	@Autowired
	private LikesRepository likesRepository;
	
	public List<LikeDto> getLikes() {
		return Mapper.toDtoList(likesRepository.findAll());
	}
	
	public LikeDto likeAnswer(LikeDto likeDto) {
		return Mapper.toDto(likesRepository.save(Mapper.toEntity(likeDto)));
	}

	public String dislikeAnswer(int likeId) {
		likesRepository.deleteById(likeId);
		return "Answer Disliked Successfully";
	}
}
