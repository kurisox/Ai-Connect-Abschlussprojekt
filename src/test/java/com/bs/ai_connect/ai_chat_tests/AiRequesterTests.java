package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.ai_chat.AiRequester;

import okhttp3.Request;


@SpringBootTest
public class AiRequesterTests {
    private AiRequester aiRequester;

    @Value("${env.data.api_endpoint}")
    private String api_endpoint;

    @Value("${env.data.content_type}")
    private String content_type;

    @Value("${env.data.json}")
    private String json;

    @BeforeEach
    public void setUp() {
        aiRequester = new AiRequester();
        Field[] fields = aiRequester.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        try {
            fields[0].set(aiRequester, true);
            fields[1].set(aiRequester, api_endpoint);
            fields[2].set(aiRequester, content_type);
            fields[3].set(aiRequester, json);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRequestBuilder_Success() {
        String content = "Test content";
        Request request = aiRequester.requestBuilder(content);
        assertNotNull(request);
    }
}
