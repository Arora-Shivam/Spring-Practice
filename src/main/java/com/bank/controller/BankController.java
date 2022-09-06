package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BankController {

	@GetMapping(value = "/account")
	public String Account() {
		return "Account Page with Spring Security";
	}
	
	
	
	
}
