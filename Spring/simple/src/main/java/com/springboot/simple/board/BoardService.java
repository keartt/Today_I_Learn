package com.springboot.simple.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList() {
        return boardRepository.findAll();
    }

    public Board getOne(Long id) {
        return boardRepository.findById(id).get();
    }

}
