package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.JdbcMemberRepository;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 스프링 컨테이너와 테스트를 함께 실행
// 스프링에서 jdbc 등 디비 설정을 다 들고 있기에 연동한 통합 테스트 실행
@SpringBootTest

//데이터베이스에서 커밋 전까지는 반영안됨, 테스트까지만 하고 콜백 때려버리기
// 테스트 시작 전 트랜잭션 시작, 테스트 후 롤백 -> 다음 테스트에 영향X : 테스트코드는 반복이 가능해야 한다.
@Transactional
class MemberServiceIntegrationTest {

    //    MemberService service = new MemberService();
//    MemoryMemberRepository repository = new MemoryMemberRepository();
    @Autowired MemberService service;
    @Autowired MemberRepository repository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello231221");
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
        assertThat(e.getMessage()).isEqualTo("이미 있지롱-s");
    }

    @Test
    void 유저조회() {
        Member member1 = new Member();
        member1.setName("찾는이름");
        service.join(member1);

        Member result = service.findOneName("찾는이름").get();
        assertThat("찾는이름").isEqualTo(result.getName());
    }

    @Test
    void 한명찾기() {
    }

}