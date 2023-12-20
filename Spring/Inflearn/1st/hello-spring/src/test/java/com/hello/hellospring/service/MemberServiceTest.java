package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    //    MemberService service = new MemberService();
//    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @AfterEach
    public void afeterEach() {
        repository.claerStrore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = service.join(member);
        //then
        Member findMember = service.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복예외처리() {
        //given
        Member member1 = new Member();
        member1.setName("중복이름");

        Member member2 = new Member();
        member2.setName("중복이름");

        //when
        service.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));
        assertThat(e.getMessage()).isEqualTo("already exist");
        
//        try {
//            service.join(member2);
//            fail("예외 있어야 함");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("already exist");
//        }

        //then
    }

    @Test
    void 유저조회() {
    }

    @Test
    void 한명찾기() {
    }
}