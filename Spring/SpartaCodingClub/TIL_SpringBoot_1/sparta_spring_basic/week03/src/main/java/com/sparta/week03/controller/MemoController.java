package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    // 생성, 조회, 변경, 삭제 하기 위해 선언해야 한다.
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")          // 스프링에 post 방식임을 선언
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);   // requestDto 에 있는 데이터가 알아서 memo로 들어감
        return memoRepository.save(memo);   // 방금 만든 memo 를 memoRepository 에 save 하고 return
    }

    @GetMapping("/api/memos")                         // get 방식으로 요청이 왔을 때!
    public List<Memo> readMemo() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(yesterday, now);    // MemoRepositroy.java 에 만들어 놨던 것 jpa 가 sql 문을 알아서 해 줌
    }

    @DeleteMapping("api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);      // 주소에 있는 아이디를 변수로 받아야 함. @PathVariable
        return id;
    }

    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

}
