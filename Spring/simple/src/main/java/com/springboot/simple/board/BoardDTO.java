package com.springboot.simple.board;

import com.springboot.simple.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
}
