package com.springboot.simple.board;

import com.springboot.simple.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList() {
        //return boardRepository.findAll();
        return boardRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public Board findById(Long id) {
        return boardRepository.findById(id).get();
    }

    public Long save(BoardDTO dto, HttpSession session) {
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user((User) session.getAttribute("user"))
                .build();

        Board save = boardRepository.save(board);
        return save.getId();
    }
    public boolean update(BoardDTO dto, HttpSession session) {
        Board origin = boardRepository.findById(dto.getId()).get();
        if (chkUser(dto.getId(), session)) {
            Board update = origin.toBuilder()
                    .id(dto.getId())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .build();
            boardRepository.save(update);
            return true;
        }
        return false;
    }

    public boolean delete(Long id, HttpSession session) {
        if (chkUser(id, session)) {
            boardRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean chkUser(Long id, HttpSession session) {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent()) {
            Long dbId = board.get().getUser().getId();
            Long sessionId = ((User) session.getAttribute("user")).getId();
            return dbId.equals(sessionId);
        }
        return false;
    }

}

