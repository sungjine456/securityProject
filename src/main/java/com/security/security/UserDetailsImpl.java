package com.security.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.security.domain.Member;

public class UserDetailsImpl extends User {
	
	private static final long serialVersionUID = -6146667858739257121L;
	
	public UserDetailsImpl(Member member) {
		super(member.getUserId(), member.getPassword(), authorities(member));
	}

	private static Collection<? extends GrantedAuthority> authorities(Member member) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getRole()));
		return authorities;
	}
}