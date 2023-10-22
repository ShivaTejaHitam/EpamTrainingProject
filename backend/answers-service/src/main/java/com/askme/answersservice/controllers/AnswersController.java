package com.askme.answersservice.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.askme.answersservice.dto.AnswerDto;
import com.askme.answersservice.services.AnswersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/answers")
@CrossOrigin
public class AnswersController{

	@Autowired
	private AnswersService answersService;

	@GetMapping()
	public ResponseEntity<List<AnswerDto>> getAllAnswers() {
		return ResponseEntity.ok().body(answersService.getAllAnswers());
	}

	@PostMapping
	public ResponseEntity<AnswerDto> postAnswer(@RequestBody @Valid AnswerDto answerDto) {
		return new ResponseEntity<AnswerDto>(answersService.postAnswer(answerDto), HttpStatus.CREATED);
	}

	@GetMapping("/{answer_id}")
	public ResponseEntity<AnswerDto> getAnswerById(@PathVariable("answer_id") int answerId) {
		return new ResponseEntity<AnswerDto>(answersService.getAnswerById(answerId), HttpStatus.OK);
	}

	@PatchMapping("/{answer_id}")
	public ResponseEntity<AnswerDto> updateAnswer(@PathVariable("answer_id") int answerId,
			@RequestBody @Valid AnswerDto answerDto) {
		return new ResponseEntity<AnswerDto>(answersService.updateAnswer(answerDto, answerId), HttpStatus.OK);
	}

	@DeleteMapping("/{answer_id}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("answer_id") int answerId) {
		return new ResponseEntity<String>(answersService.deleteAnswer(answerId), HttpStatus.NO_CONTENT);
	}

}
