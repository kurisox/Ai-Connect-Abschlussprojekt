package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_chat.AiConversationChat;

@SpringBootTest
public class AiConversationChatTests {
    private AiConversationChat aiConversationChat;

    @BeforeEach
    public void setup(){
        this.aiConversationChat = new AiConversationChat();
    }

    @Test
    public void testAskAISuccess(){
        String result = aiConversationChat.askAi("content");
        assertEquals("",result);
    }
}
