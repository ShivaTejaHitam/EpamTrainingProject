package com.askme.commentsservice.controllers;

import java.util.List;




import jakarta.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.services.CommentsService;



@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping()
	public ResponseEntity<List<CommentDto>> commentsList(){
		return  ResponseEntity.ok().body(commentsService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentDto commentDto){
		return new ResponseEntity<CommentDto>(commentsService.save(commentDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{comment_id}")
	public ResponseEntity<CommentDto> viewComment(@PathVariable("comment_id") int commentId) {
		return new ResponseEntity<CommentDto>(commentsService.findById(commentId),HttpStatus.OK);
	}

	@PutMapping("/{comment_id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable("comment_id") int commentId,@RequestBody @Valid CommentDto commentDto){
		return new ResponseEntity<CommentDto>(commentsService.update(commentDto,commentId),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{comment_id}")
	public ResponseEntity<String> deleteComment(@PathVariable("comment_id") int commentId){
		return new ResponseEntity<String>(commentsService.delete(commentId),HttpStatus.NO_CONTENT);
	}
}
