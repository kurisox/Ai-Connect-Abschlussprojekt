package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_chat.AiContext;
import com.bs.ai_connect.dto.MessageDTO;

@SpringBootTest
public class AiContextTests {

    private AiContext aiContext;

    @BeforeEach
    public void setup(){
        this.aiContext = new AiContext();
    }

    @Test
    public void testAddMessage_Success() {
        MessageDTO message = new MessageDTO();
        boolean result = aiContext.addMessage(message);
        assertTrue(result);
    }

    @Test
    public void testResetContent() {
        aiContext.addMessage(new MessageDTO());
        int result = aiContext.resetContent();
        assertEquals(0, result);
    }

    @Test
    public void testSummarizeMessages() {
        aiContext.addMessage(new MessageDTO());
        aiContext.addMessage(new MessageDTO());
        int result = aiContext.summarizeMessages();
        assertEquals(1, result);
    }
    
}
