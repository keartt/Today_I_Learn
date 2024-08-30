package com.springboot.simple.board;

import com.springboot.simple.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @Description("목록조회")
    @GetMapping("/board/list")
    public List<Board> get() {
        return boardService.getList();
    }

    @Description("작성하기")
    @PostMapping("/board")
    public Long write(@RequestBody BoardDTO dto, HttpSession session) {
        return boardService.save(dto, session);
    }

    @Description("상세보기")
    @GetMapping("/board/{id}")
    public Board detail(@PathVariable("id") Long id) {
        return boardService.findById(id);
    }

    @Description("수정하기")
    @PutMapping("/board")
    public boolean update(@RequestBody BoardDTO dto, HttpSession session){
        return boardService.update(dto, session);
    }

    @Description("삭제하기")
    @DeleteMapping("/board/{id}")
    public boolean delete(@PathVariable("id") Long id, HttpSession session){
        return boardService.delete(id, session);
    }

}
