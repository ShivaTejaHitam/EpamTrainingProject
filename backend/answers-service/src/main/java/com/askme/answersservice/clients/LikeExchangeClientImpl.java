package com.askme.answersservice.clients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.askme.answersservice.dto.LikeDto;

import jakarta.validation.Valid;

public class LikeExchangeClientImpl implements LikeExchangeClient {
	
	@GetMapping("/likes")
	public ResponseEntity<List<LikeDto>> getLikes(){
		return null;
	}
	
	@PostMapping("/likes")
	public ResponseEntity<LikeDto> likeAnswer(@RequestBody @Valid LikeDto likeDto){
		return null;
	}
	
	@DeleteMapping("/likes/{like_id}")
	public ResponseEntity<String> dislikeAnswer(@PathVariable("like_id") int likeId){
		return null;
	}
}
