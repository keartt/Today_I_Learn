package com.springboot.simple.rtc;

import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class SignalingHandler extends TextWebSocketHandler {

    // 현재 접속된 모든 세션을 저장
    private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    // 웹소켓 연결 시
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info(">>> [ws] 클라이언트 접속 : 세션 - {}", session);
        sessions.add(session); // 세션 저장
    }

    // 웹소켓 연결 종료 시
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info(">>> [ws] 클라이언트 연결 종료 : 세션 - {}", session);
        sessions.remove(session); // 세션 삭제
    }

    // 클라이언트로부터 메시지를 받을 때
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info(">>> [ws] 받은 메시지 : {}", payload);

        // 받은 메시지를 파싱해서 메시지 타입에 따라 처리
        JSONObject jsonMessage = new JSONObject(payload);
        String type = jsonMessage.getString("type");

        switch (type) {
            case "offer":
                handleOffer(session, jsonMessage);
                break;
            case "answer":
                handleAnswer(session, jsonMessage);
                break;
            case "join":
                handleJoin(session, jsonMessage);
                break;
            case "candidate":
                handleCandidate(session, jsonMessage);
                break;
            default:
                log.warn("Unknown message type: " + type);
                break;
        }
    }

    // 클라이언트에서 offer를 받으면 다른 세션에 브로드캐스트
    private void handleOffer(WebSocketSession session, JSONObject message) throws Exception {
        log.info(">>> Handling offer");
        for (WebSocketSession s : sessions) {
            if (s.isOpen() && !s.equals(session)) {
                s.sendMessage(new TextMessage(message.toString()));
            }
        }
    }

    // 클라이언트에서 answer를 받으면 다른 세션에 브로드캐스트
    private void handleAnswer(WebSocketSession session, JSONObject message) throws Exception {
        log.info(">>> Handling answer");
        for (WebSocketSession s : sessions) {
            if (s.isOpen() && !s.equals(session)) {
                s.sendMessage(new TextMessage(message.toString()));
            }
        }
    }

    // 새로운 참가자가 join할 때 처리
    private void handleJoin(WebSocketSession session, JSONObject message) throws Exception {
        log.info(">>> Handling join");
        // 현재 세션에 참가자 리스트를 전송할 수도 있고, 다른 세션에 참가자 정보 전송
        for (WebSocketSession s : sessions) {
            if (s.isOpen() && !s.equals(session)) {
                s.sendMessage(new TextMessage(message.toString()));
            }
        }
    }

    // ICE candidate 메시지를 처리
    private void handleCandidate(WebSocketSession session, JSONObject message) throws Exception {
        log.info(">>> Handling candidate");
        for (WebSocketSession s : sessions) {
            if (s.isOpen() && !s.equals(session)) {
                s.sendMessage(new TextMessage(message.toString()));
            }
        }
    }
}