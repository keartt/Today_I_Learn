package com.springboot.simple;

import com.springboot.simple.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    String login(Model model){
        model.addAttribute("name", "홍길동");
        User user = new User();
        return "login";
    }

    @GetMapping("/join")
    String join(Model model){
        model.addAttribute("name", "홍길동");
        User user = new User();
        return "join";
    }

    @GetMapping("/write")
    String write(Model model){
        model.addAttribute("name", "홍길동");
        User user = new User();
        return "write";
    }

    @GetMapping("/list")
    String list(Model model, HttpSession session){

        session.setAttribute("test", "session값");
        model.addAttribute("name", session.getAttribute("test"));
        User user = new User();
        return "list";
    }

}
