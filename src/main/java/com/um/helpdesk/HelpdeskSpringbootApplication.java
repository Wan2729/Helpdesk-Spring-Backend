package com.um.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HelpdeskSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskSpringbootApplication.class, args);
	}

}
