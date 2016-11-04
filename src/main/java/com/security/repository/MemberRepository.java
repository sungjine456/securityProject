package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	public Member findByUserId(String userId);
}
