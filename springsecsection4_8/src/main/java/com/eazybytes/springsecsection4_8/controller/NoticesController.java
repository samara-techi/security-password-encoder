package com.eazybytes.springsecsection4_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/notice")
public class NoticesController {
	
	
	@GetMapping("/")
	public String notice() {		
		return "notice() @NoticesController";
	}

}
