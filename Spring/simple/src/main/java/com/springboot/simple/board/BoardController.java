package com.springboot.simple.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/board/list")
    public List<Board> get() {
        return boardService.getList();
    }

    @PostMapping("/get")
    public String getPost() {
        return "getPOst";
    }
}
