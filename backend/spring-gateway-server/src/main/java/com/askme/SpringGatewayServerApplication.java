package com.askme;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@CrossOrigin
public class SpringGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayServerApplication.class, args);
	}
}
