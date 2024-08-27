package com.springboot.simple.user;

import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @Description("로그인 여부 확인")
    @GetMapping("/login/check")
    public boolean loginChk(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        User user = User.builder()
                .userId(id)
                .pw(pw).build();
        System.out.println(user.getUserId());
        System.out.println(user.getPw());
        return true;
    }
    @Description("회원가입")
    @PostMapping("/join")
    public boolean join(@RequestBody User user) {
        boolean duplicate = true;
        if (duplicate){

        }
        return duplicate;
    }

    @Description("로그인")
    @PostMapping("/login")
    public boolean login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        boolean duplicate = true;
        if (duplicate){

        }
        return duplicate;
    }





}
