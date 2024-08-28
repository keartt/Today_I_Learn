package com.springboot.simple.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="user_info")
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String userId;

    @Column(nullable = false, length = 255)
    private String pw;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(updatable = false, insertable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime editTime;

    @Builder(toBuilder = true)
    public User(Long id, String userId, String pw, String name) {
        this.id = id;
        this.userId = userId;
        this.pw = pw;
        this.name = name;
    }


    @PrePersist
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
        this.editTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.editTime = LocalDateTime.now();
    }
}
