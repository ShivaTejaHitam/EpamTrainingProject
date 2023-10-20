package com.askme.commentsservice.services;

import java.sql.Timestamp;



import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.entities.Comment;
import com.askme.commentsservice.exceptions.CommentNotFoundException;
import com.askme.commentsservice.mapper.Mapper;
import com.askme.commentsservice.repositories.CommentsRepository;



@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	public CommentDto save(CommentDto commentDto) {
		commentDto.setTimestamp(Timestamp.from(Instant.now()));
		return Mapper.toDto(commentsRepository.save(Mapper.toEntity(commentDto)));
	}
	
	public List<CommentDto> findAll() {
		return Mapper.toDtoList(commentsRepository.findAll());
	}

	public CommentDto findById(int commentId) {
		Optional<Comment> commentOptional = commentsRepository.findById(commentId);
		return Mapper.toDto(commentOptional.orElseThrow(() -> new CommentNotFoundException("Comment with Comment Id : " + commentId + " Not Found")));
	}

	public String delete(int commentId) {
		findById(commentId);
		commentsRepository.deleteById(commentId);
		return "Comment Deleted Successfully";
	}
	
	public CommentDto update(CommentDto commentDto,int commentId) {
		findById(commentId);
		return Mapper.toDto(commentsRepository.save(Mapper.toEntity(commentDto)));
	}
}
