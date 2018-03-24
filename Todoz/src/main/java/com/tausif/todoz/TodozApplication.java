package com.tausif.todoz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TodozApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodozApplication.class, args);
	}
}
