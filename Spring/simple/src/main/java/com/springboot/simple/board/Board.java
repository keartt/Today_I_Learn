package com.springboot.simple.board;

import com.springboot.simple.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity @Table
@Getter @Setter @ToString
public class Board {
    @Id
    private Long id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime editTime;

}
