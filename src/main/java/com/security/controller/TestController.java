package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String test(){
		return "hello";
	}
	
	@RequestMapping("/admin")
	public String adminView(){
		return "admin";
	}
}
