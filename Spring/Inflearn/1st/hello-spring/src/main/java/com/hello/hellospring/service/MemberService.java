package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //    private final MemoryMemberRepository repository = new MemoryMemberRepository();
    private final MemoryMemberRepository repository;

    public MemberService(MemoryMemberRepository repository) {
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

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("already exist");
                });
    }


}
