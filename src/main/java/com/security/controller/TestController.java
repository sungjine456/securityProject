package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.domain.Member;
import com.security.repository.MemberRepository;
import com.security.security.UserDetailsImpl;

@Controller
public class TestController {
	
	@Autowired private MemberRepository memberRepository;
	
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
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinView(){
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		memberRepository.save(member);
		
		UserDetailsImpl userDetails = new UserDetailsImpl(member);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
		return "hello";
	}
	
	@RequestMapping("/privateMessage")
	@PreAuthorize("(#member.userId == principal.username) or hasRole('ROLE_ADMIN')")
	public String authstring(Member member, Model model) {
		model.addAttribute("msg", "당신은 관리자거나 요청 파라미터랑 아이디가 같습니다?");
		return "authMsg";
	}

	@RequestMapping("/userMessage")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userMesasge(Member member, Model model){
		model.addAttribute("msg", "당신은 유저입니다.");
		return "authMsg";
	}
}
