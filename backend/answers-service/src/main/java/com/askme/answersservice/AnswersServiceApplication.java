package com.askme.answersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnswersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswersServiceApplication.class, args);
	}

}
