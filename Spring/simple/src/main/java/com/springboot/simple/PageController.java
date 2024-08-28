package com.springboot.simple;

import com.springboot.simple.board.Board;
import com.springboot.simple.board.BoardService;
import com.springboot.simple.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final BoardService boardService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    String login(){
        return "login";
    }

    @GetMapping("/join")
    String join(){
        return "join";
    }

    @GetMapping("/write")
    String write(){
        return "write";
    }

    @GetMapping("/list")
    String list(){
        return "list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("board",  boardService.getOne(id));
        return "detail";
    }

}
