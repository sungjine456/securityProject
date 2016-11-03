package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String test(){
		return "hello";
	}
	
	@RequestMapping("/admin")
	public String adminView(){
		return "admin";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
