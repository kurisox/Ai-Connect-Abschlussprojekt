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
    private String message = "Hello, World!";

    @BeforeEach
    public void setup(){
        this.aiContext = new AiContext();
    }

    @Test
    public void testAddMessage_Success() {
        MessageDTO message = new MessageDTO(this.aiContext.getRole(), this.message);
        boolean result = aiContext.addMessage(message);
        assertTrue(result);
    }

    @Test
    public void testResetContent() {
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));   
        assertEquals(1, aiContext.resetContent());
    }

    @Test
    public void testSummarizeMessages() {
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        assertEquals(1, aiContext.summarizeMessages());
    }
    
}
