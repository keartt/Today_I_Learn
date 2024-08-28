package com.springboot.simple.user;

import com.springboot.simple.board.Board;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Description("로그인 여부 확인")
    @GetMapping("/login/check")
    public User loginChk(HttpSession session) {
        Object user = session.getAttribute("user");
        if (user != null) {
            return (User) user;
        }
        Board board = new Board();
        return null;
    }
    @Description("회원가입")
    @PostMapping("/join")
    public boolean join(@RequestBody User user) {
        return userService.join(user);
    }

    @Description("로그인")
    @PostMapping("/login")
    public boolean login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {
        Optional<User> login = userService.login(id, pw);
        if (login.isPresent()) {
            session.setAttribute("user",login.get());
            return true;
        }
        return false;
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
    
}
