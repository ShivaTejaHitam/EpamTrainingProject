package com.askme.questionsservice.clients;

import java.util.List;


import jakarta.validation.Valid;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.askme.questionsservice.dto.AnswerDto;

@FeignClient(name = "answers-service", fallback = AnswerExchangeClientImpl.class)
@LoadBalancerClient(name = "answers-service", configuration = AnswerExchangeClientImpl.class)
public interface AnswerExchangeClient {

	@GetMapping("/answers/{answer_id}")
	public ResponseEntity<AnswerDto> getAnswerById(@PathVariable("answer_id") int answerId);

	@GetMapping("/answers")
	public ResponseEntity<List<AnswerDto>> getAnswers();

	@PostMapping("/answers")
	public ResponseEntity<AnswerDto> createAnswer(@RequestBody @Valid AnswerDto answerDto);

	@PutMapping("/answers/{answer_id}")
	public ResponseEntity<AnswerDto> updateAnswer(@PathVariable("answer_id") int answerId,
			@RequestBody @Valid AnswerDto answerDto);

	@DeleteMapping("/answers/{answer_id}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("answer_id") int answerId);
}
