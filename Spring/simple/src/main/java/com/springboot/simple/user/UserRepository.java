package com.springboot.simple.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userI);
    Optional<User> findByUserIdAndPw(String userId, String pw);
}
