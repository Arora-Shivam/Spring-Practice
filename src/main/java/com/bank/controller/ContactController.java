package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ContactController {

	@GetMapping(value="/contact")
	public String contact() {
		return "Contact Page without Spring Security";
	}
}
