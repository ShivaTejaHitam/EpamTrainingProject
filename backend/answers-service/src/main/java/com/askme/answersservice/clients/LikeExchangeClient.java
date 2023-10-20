package com.askme.answersservice.clients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.askme.answersservice.dto.LikeDto;

import jakarta.validation.Valid;

@FeignClient(name = "likes-service", fallback = LikeExchangeClientImpl.class)
@LoadBalancerClient(name = "likes-service", configuration = LikeExchangeClientImpl.class)
public interface LikeExchangeClient {
	
	@GetMapping("/likes")
	public ResponseEntity<List<LikeDto>> getLikes();
	
	@PostMapping("/likes")
	public ResponseEntity<LikeDto> likeAnswer(@RequestBody @Valid LikeDto likeDto);
	
	@DeleteMapping("/likes/{like_id}")
	public ResponseEntity<String> dislikeAnswer(@PathVariable("like_id") int likeId);
}
