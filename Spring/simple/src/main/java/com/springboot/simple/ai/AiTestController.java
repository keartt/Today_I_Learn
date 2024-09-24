package com.springboot.simple.ai;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class AiTestController {
    private final OpenAiChatModel openAiChatModel;

    @GetMapping("/ai/test/1")
    public String test1(@RequestBody String msg) {
        return openAiChatModel.call(msg);
    }

}
