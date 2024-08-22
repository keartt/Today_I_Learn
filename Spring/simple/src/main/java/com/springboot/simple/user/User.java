package com.springboot.simple.user;

import com.springboot.simple.board.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Entity @Table(name="user_info")
@Getter @Setter @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255, unique = true)
    private String userId;

    @Column(nullable = false, length = 255)
    private String pw;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createTime;

    @Column(name = "editTime")
    private LocalDateTime editTime;

    @OneToMany(mappedBy = "user")
    private Set<Board> boards;

}
