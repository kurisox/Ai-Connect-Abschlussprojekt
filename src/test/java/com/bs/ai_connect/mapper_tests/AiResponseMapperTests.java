package com.bs.ai_connect.mapper_tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.mapper.AiResponseMapper;

import okhttp3.ResponseBody;

@SpringBootTest
public class AiResponseMapperTests {
    @Test
    public void testGetInstance(){
        assertNotNull(AiResponseMapper.getInstance());
    }

    @Test
    public void testGetInstance_Singleton(){
        assertSame(AiResponseMapper.getInstance(), AiResponseMapper.getInstance());
    }

    @Test
    public void testMapResponse(){
        ResponseBody responseBody = null;
        assertNotNull(AiResponseMapper.mapResponse(responseBody));
    }
}
