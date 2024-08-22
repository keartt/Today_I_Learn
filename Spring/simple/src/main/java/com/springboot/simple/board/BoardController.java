package com.springboot.simple.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/get")
    public String getPost() {
        return "getPOst";
    }
}
