package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
    //    private final MemoryMemberRepository repository = new MemoryMemberRepository();
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    /**
     * 전체조회
     */
    public  List<Member> findMembers() {
        return repository.findAll();
    }

    /**
     * 한명조회
     */
    public Optional<Member> findOne  (Long memberId) {
        return repository.findById(memberId);
    }

    public Optional<Member> findOneName  (String memberName) {
        return repository.findByName(memberName);
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 있지롱-s");
                });
    }


}
