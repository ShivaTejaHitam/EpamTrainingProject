package com.askme.answersservice.clients;

import java.util.List;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.askme.answersservice.dto.CommentDto;

import jakarta.validation.Valid;

@FeignClient(name = "comments-service", fallback = CommentExchangeClientImpl.class)
@LoadBalancerClient(name = "comments-service", configuration = CommentExchangeClientImpl.class)
public interface CommentExchangeClient {

	@GetMapping("/comments/{comment_id}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable("comment_id") int commentId);

	@GetMapping("/comments")
	public ResponseEntity<List<CommentDto>> getComments();

	@PostMapping("/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentDto commentDto);

	@PutMapping("/comments/{comment_id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable("comment_id") int commentId,
			@RequestBody @Valid CommentDto commentDto);

	@DeleteMapping("/comments/{comment_id}")
	public ResponseEntity<String> deleteComment(@PathVariable("comment_id") int commentId);
}
