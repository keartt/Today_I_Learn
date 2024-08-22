package com.springboot.simple;

import com.springboot.simple.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/test";
    }
    @GetMapping("/test")
    String init(Model model){
        model.addAttribute("name", "홍길동");
        User user = new User();
        return "test";
    }
}
