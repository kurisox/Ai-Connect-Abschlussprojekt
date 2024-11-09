package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_chat.AiContext.AiContext;
import com.bs.ai_connect.dto.MessageDTO;

@SpringBootTest
public class AiContextTests {

    private AiContext aiContext;
    private String message = "Hello, World!";

    @Value("${env.data.mockMode}")
    private boolean mockMode;

    @Value("${env.data.aiPersona}")
    private String aiPersona;

    @Value("${env.data.role}")
    private String role;

    @Value("${env.data.summarizedMsg}")
    private String summarizeMsg;

    @Value("${env.data.userRole}")
    private String userRole;

    @BeforeEach
    public void setup() {
        this.aiContext = new AiContext();
        Field[] fields = aiContext.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        try {
            fields[0].set(aiContext, mockMode);
            fields[3].set(aiContext, aiPersona);
            fields[4].set(aiContext, role);
            fields[5].set(aiContext, summarizeMsg);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
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
    public void testSummarizeMessages1() {
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        assertEquals(1, aiContext.summarizeMessages(userRole, "model", 200));
    }

    @Test
    public void testSummarizeMessages2() {
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        aiContext.addMessage(new MessageDTO(this.aiContext.getRole(), this.message));
        MessageDTO message = new MessageDTO(this.aiContext.getRole(), this.message);
        assertEquals(message, aiContext.getMessages().get(0));
    }

}
