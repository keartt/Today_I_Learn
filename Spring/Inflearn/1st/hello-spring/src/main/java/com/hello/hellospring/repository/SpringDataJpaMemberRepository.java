package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //Jpa repository 를 받고 있으면 구현체를 자동으로 만들고 스프링 빈에 등록해줌
    @Override
    Optional<Member> findByName(String name);

}
