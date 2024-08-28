package com.springboot.simple.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public boolean join(User user) {
        // 아이디 있는지 확인
        if (userRepository.findByUserId(user.getUserId()).isPresent()) {
            return false;
        }else{
            userRepository.save(user);
            return true;
        }
    }

    public Optional<User> login(String id, String pw) {
        return userRepository.findByUserIdAndPw(id, pw);
    }

    public User loginChk(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return (User) user;
        }
        return null;
    }
}
