package com.bs.ai_connect.mapper_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.dto.ContextDTO;

import com.bs.ai_connect.mapper.JavaToJSONMapper;



@SpringBootTest
public class JavaToJSONMapperTests {
    @Test
    public void testGetInstance(){
        assertNotNull(JavaToJSONMapper.getInstance());
    }

    @Test
    public void testGetInstance_Singleton(){
        assertSame(JavaToJSONMapper.getInstance(), JavaToJSONMapper.getInstance());
    }

    @Test
    public void testMapResponse(){
        assertEquals(new ContextDTO(),JavaToJSONMapper.mapJSON(new ContextDTO()));
    }
}
