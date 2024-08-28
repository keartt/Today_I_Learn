package com.springboot.simple.board;

import com.springboot.simple.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
