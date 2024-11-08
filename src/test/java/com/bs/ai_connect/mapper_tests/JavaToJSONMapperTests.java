package com.bs.ai_connect.mapper_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.dto.ContextDTO;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.mapper.JavaToJSONMapper;
import com.fasterxml.jackson.core.JsonProcessingException;





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
        List<MessageDTO> messages = List.of(new MessageDTO("system","Hello from AI"));
        String compareable = "{\"model\":\"gpt-3.5-turbo\",\"max_tokens\":1024,\"messages\":[{\"role\":\"system\",\"content\":\"Hello from AI\"}]}";
        ContextDTO testContext = new ContextDTO("gpt-3.5-turbo",1024, messages);
        String contextToJSON;
        try {
            contextToJSON = JavaToJSONMapper.mapJSON(testContext);
            assertEquals(compareable,contextToJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
