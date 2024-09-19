package com.springboot.simple.rtc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.WebSocketHandler;

@Configuration
@EnableWebSocket // web sc 자동설정
public class WebRtcConfig implements WebSocketConfigurer {
    /* TODO WebRTC 관련 */

    // signal 로 요청이 왔을 때 아래의 signalingSocketHandler 가 동작하도록 registry 에 설정
    // 요청은 클라이언트 접속, close, 메시지 발송 등에 대해 특정 메서드를 호출한다
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(signalingSocketHandler(), "/signal")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Bean
    public WebSocketHandler signalingSocketHandler() {
        return new SignalingHandler();
    }
}
