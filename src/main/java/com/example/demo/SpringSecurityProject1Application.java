package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bank")
public class SpringSecurityProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProject1Application.class, args);
	}

}