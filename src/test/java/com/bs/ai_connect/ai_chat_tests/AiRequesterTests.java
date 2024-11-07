package com.bs.ai_connect.ai_chat_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.ai_chat.AiRequester;

import okhttp3.Request;
import okhttp3.ResponseBody;

@SpringBootTest
public class AiRequesterTests {
    private AiRequester aiRequester;

    @Value("${env.data.api_endpoint}")
    private String apiEndpoint;

    @BeforeEach
    public void setUp() {
        aiRequester = new AiRequester();
    }

    @Test
    public void testRequestBuilder_Success() {
        String content = "Test content";
        Request request = aiRequester.requestBuilder(content);
        assertNotNull(request);
    }


    @Test
    public void testApiCall_Success() {
        Request request = new Request.Builder().url(apiEndpoint).build();
        ResponseBody responseBody = aiRequester.apiCall(request);
        assertNotNull(responseBody);
    }

}
