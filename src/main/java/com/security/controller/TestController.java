package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public @ResponseBody String test(){
		return "hello";
	}
	
	@RequestMapping("/admin")
	public @ResponseBody String adminView(){
		return "admin";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
