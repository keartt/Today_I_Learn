package com.hello.hellospring;

import com.hello.hellospring.repository.JdbcMemberRepository;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 자바코드를 이용한 DI 의존성 주입
 * 컴포넌트 스캔 어노테이션을 일일히 바꿀 필요 없이
 * 원하는 repository 등 을 바로 여기서 직접 바꿔줄 수있음
 * but 컨트롤러는 안댐
 */

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
