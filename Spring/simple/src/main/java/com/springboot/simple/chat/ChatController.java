package com.springboot.simple.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate; // 메시지를 특정 경로로 복내기 위해 사용

    //입장을 할 때 사용하는 루트입니다.
    @MessageMapping("/chat/enter")
    public void enter(@Payload ChatRequestDto dto, @Header("room") String roomNum) {
        messagingTemplate.convertAndSend("/sub/chat/room/" + roomNum, dto);
    }

    //메세지를 전송할 때 사용하는 루트입니다.
    @MessageMapping("/chat/message")
    public void message(@Payload ChatRequestDto dto, @Header("room") String roomNum) {
        messagingTemplate.convertAndSend("/sub/chat/room/" + roomNum, dto);
    }

    @MessageMapping("/chat/screen")
    public void screenShare(@Payload byte[] data, @Header("room") String roomNum) {
        // Broadcast the screen share data to all clients in the room
        messagingTemplate.convertAndSend("/sub/chat/room/" + roomNum, data);
    }

}