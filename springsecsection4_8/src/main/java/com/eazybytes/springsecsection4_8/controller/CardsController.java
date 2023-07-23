package com.eazybytes.springsecsection4_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/card")
public class CardsController {
	
	@GetMapping("/")
	public String cards() {
		return "cards() @CardsController";
	}

}
