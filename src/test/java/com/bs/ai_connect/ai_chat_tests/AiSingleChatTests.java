package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_chat.AiSingleChat;

@SpringBootTest
public class AiSingleChatTests {

    private AiSingleChat aiSingleChat;

    @BeforeEach
    public void setUp() {
        aiSingleChat = new AiSingleChat();
    }

    @Test
    public void testAskAi_Success() {
        String content = "Test content";
        String response = aiSingleChat.askAi(content);
        assertEquals("Hello from AI", response);
    }
}