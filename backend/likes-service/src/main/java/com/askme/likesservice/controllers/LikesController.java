package com.askme.likesservice.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


import com.askme.likesservice.dto.LikeDto;
import com.askme.likesservice.services.LikesService;


@RestController
@RequestMapping("/likes")
@CrossOrigin
public class LikesController {
	
	@Autowired
	private LikesService likesService;
	
	@GetMapping()
	public ResponseEntity<List<LikeDto>> getLikes(){
		return  ResponseEntity.ok().body(likesService.getLikes());
	}
	
	@PostMapping
	public ResponseEntity<LikeDto> likeAnswer(@RequestBody @Valid  LikeDto likeDto){
		return new ResponseEntity<LikeDto>(likesService.likeAnswer(likeDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping()
	public ResponseEntity<String> dislikeAnswer(@RequestParam("likeId") int likeId){
		return new ResponseEntity<String>(likesService.dislikeAnswer(likeId),HttpStatus.NO_CONTENT);
	}
}
