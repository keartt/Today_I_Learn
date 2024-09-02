package com.springboot.simple;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    @GetMapping("/")
    public String redirectToLogin(HttpSession session) {
        String url;
        if (session.getAttribute("user") ==null){
            url = "/login";
        }else{
            url = "/board";
        }
        return "redirect:" + url;
    }

    @GetMapping("/chat")
    public String chat() {
        return "/chat";
    }

    @GetMapping("/login")
    String login(){
        return "login";
    }

    @GetMapping("/join")
    String join(){
        return "join";
    }

    @GetMapping("/board")
    String write(){
        return "board";
    }
}
