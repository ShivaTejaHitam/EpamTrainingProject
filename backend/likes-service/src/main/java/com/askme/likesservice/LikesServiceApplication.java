package com.askme.likesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class LikesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikesServiceApplication.class, args);
	}
	
	@GetMapping()
	public String defa() {
		return "Welcome to my app";
	}

}
