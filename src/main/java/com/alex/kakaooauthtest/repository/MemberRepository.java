package com.alex.kakaooauthtest.repository;

import com.alex.kakaooauthtest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}