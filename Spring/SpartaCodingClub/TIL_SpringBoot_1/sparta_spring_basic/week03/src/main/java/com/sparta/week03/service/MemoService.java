package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor        //final 로 선언된 것이 있으면 생성자 꼭 생성해줘
@Service                        // 이건 서비스야
public class MemoService {

    private final MemoRepository memoRepository;    //final : 꼭 필요한 것을 알려준다.

    @Transactional                                  // updatd를 할 때 db에 반영이 될 것을 한번 더 얘기해야 함
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(    //id를 기준으로 찾고.없으면 오류 발생 시켜라
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")   // 오류발생 시
        );
        memo.update(requestDto);
        return memo.getId();
    }
}