package com.askme.questionsservice.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.askme.questionsservice.dto.QuestionDto;
import com.askme.questionsservice.services.QuestionsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;

	@PostMapping
	public ResponseEntity<QuestionDto> createQuestion(@RequestBody @Valid QuestionDto questionDto) {
		return new ResponseEntity<QuestionDto>(questionsService.save(questionDto), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<QuestionDto>> questionsList() {
		return ResponseEntity.ok().body(questionsService.findAll());
	}

	@GetMapping("/{question_id}")
	public ResponseEntity<QuestionDto> viewQuestion(@PathVariable("question_id") int questionId) {
		return new ResponseEntity<QuestionDto>(questionsService.findById(questionId), HttpStatus.OK);
	}

	@PutMapping("/{question_id}")
	public ResponseEntity<QuestionDto> updateQuestion(@PathVariable("question_id") int questionId,
			@RequestBody @Valid QuestionDto questionDto) {
		return new ResponseEntity<QuestionDto>(questionsService.update(questionDto, questionId), HttpStatus.OK);
	}

	@DeleteMapping("/{question_id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("question_id") int questionId) {
		return new ResponseEntity<String>(questionsService.delete(questionId), HttpStatus.NO_CONTENT);
	}

}
