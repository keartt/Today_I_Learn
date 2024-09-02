package com.springboot.simple.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 웹소켓 메시지 브로커 활성화 -> STOMP
public class WebSokectConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")         // 웹소켓 엔드포인트 등록
                .setAllowedOriginPatterns("*")      // 모든 도메인 허용 (cors)
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // sub 는 어디 room 으로 보낼지 시작시 정해주는것
        registry.enableSimpleBroker("/sub");  // 구독경로 prefix 지정 (수신경로)

        // pub 는 메시지를 보낼때 messangeMapping 주소에 매핑되게 하는것
        registry.setApplicationDestinationPrefixes("/pub");     // 서버로 보낼때 사용할 prefix -> @MessageMapping
    }
}