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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.services.CommentsService;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	@GetMapping()
	public ResponseEntity<List<CommentDto>> getAllComments() {
		return ResponseEntity.ok().body(commentsService.getAllComments());
	}

	@PostMapping
	public ResponseEntity<CommentDto> postComment(@RequestBody @Valid CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentsService.postComment(commentDto), HttpStatus.CREATED);
	}

	@GetMapping("/{comment_id}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable("comment_id") int commentId) {
		return new ResponseEntity<CommentDto>(commentsService.getCommentById(commentId), HttpStatus.OK);
	}

	@PatchMapping("/{comment_id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable("comment_id") int commentId,
			@RequestBody @Valid CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentsService.updateComment(commentDto, commentId), HttpStatus.OK);
	}

	@DeleteMapping("/{comment_id}")
	public ResponseEntity<String> deleteComment(@PathVariable("comment_id") int commentId) {
		return new ResponseEntity<String>(commentsService.deleteComment(commentId), HttpStatus.NO_CONTENT);
	}
}
