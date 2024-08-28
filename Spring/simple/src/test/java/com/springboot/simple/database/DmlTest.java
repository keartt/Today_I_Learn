package com.springboot.simple.database;

import com.springboot.simple.board.Board;
import com.springboot.simple.board.BoardRepository;
import com.springboot.simple.user.User;
import com.springboot.simple.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DmlTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void getSimple() {
        var var1 = userRepository.findById(1L).get().getName();
        var var2 = userRepository.findAll().get(0).getName();
        assertThat(var1).isEqualTo(var2);
    }

    @Test
    @Transactional
    void insertFind() {
        User user = User.builder()
                .userId("아이디")
                .pw("비밀번호")
                .name("이름")
                .build();
        User save = userRepository.save(user);

        User savedUser = userRepository.findById(save.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        assertThat(user.getUserId()).isEqualTo(savedUser.getUserId());
    }

    @Test
    @Transactional
    void update() {
        User user = User.builder()
                .userId("아이디")
                .pw("비밀번호")
                .name("이름")
                .build();
        userRepository.save(user);

        User updateUser = user.toBuilder()
                .userId("admin")
                .name("관리자")
                .pw("1234").build();
        userRepository.save(updateUser);

        User savedUser = userRepository.findById(updateUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        assertThat(savedUser.getUserId()).isEqualTo(updateUser.getUserId());
        assertThat(savedUser.getName()).isEqualTo(updateUser.getName());
        assertThat(savedUser.getPw()).isEqualTo(updateUser.getPw());
    }
    @Test
    @Transactional
    void delete() {
        User user = User.builder()
                .userId("아이디")
                .pw("비밀번호")
                .name("이름")
                .build();
        userRepository.save(user);

        userRepository.delete(user);

        assertThat(userRepository.findById(user.getId()).isEmpty()).isTrue();
    }

    @Test
    void mkMethod() {
        User user = userRepository.findByUserIdAndPw("admin", "1234")
                .orElseThrow(() -> new RuntimeException("no user"));
        assertThat(user).isNotNull();
    }

    @Test
    void manyToOne() {
        User user = userRepository.findByUserIdAndPw("admin", "1234").get();
        Board board = Board.builder()
                .title("제목")
                .content("con")
                .user(user)
                .build();
        Board save = boardRepository.save(board);

        Board saved = boardRepository.findById(save.getId())
                .orElseThrow(() -> new RuntimeException("Board not found"));
        assertThat(saved.getTitle()).isEqualTo(board.getTitle());
        assertThat(saved.getContent()).isEqualTo(board.getContent());
    }
}
