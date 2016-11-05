package com.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.domain.Member;
import com.security.repository.MemberRepository;

@SpringBootApplication
public class SecurityProjectApplication {

	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);
	}

	@Bean
	InitializingBean insertFixtureUsers() {
		return () -> {
			Member member = new Member();
			member.setUserId("admin");
			member.setPassword(passwordEncoder.encode("1234"));
			member.setRole("ROLE_ADMIN");
			memberRepository.save(member);

			Member user = new Member();
			user.setUserId("user");
			user.setPassword(passwordEncoder.encode("1234"));
			user.setRole("ROLE_USER");
			memberRepository.save(user);
		};
	}
}
