package com.bs.ai_connect.mapper_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.bs.ai_connect.dto.ChoicesDTO;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.dto.UsageDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

@SpringBootTest
public class AiResponseMapperTests {
    
    @Value("${env.data.json}")
    private String json;
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
        String jsonResponse = "{\"id\":\"id\",\"object\":\"object\",\"created\":1,\"model\":\"model\",\"choices\":[{\"id\":1,\"message\":{\"role\":\"system\",\"content\":\"Hello from AI\"},\"logprobs\":\"logprobs\",\"finish\":\"finisched\"}],\"usage\":{\"id\":1,\"turn\":1,\"timestamp\":1}}";
        ResponseBody responseBody = ResponseBody.create(jsonResponse, MediaType.get(json));
        ResponseDTO prototypeResponse = getPrototypeResponse();
        ResponseDTO methodResponse;

        try {
            methodResponse = AiResponseMapper.mapResponse(responseBody);
            assertEquals(prototypeResponse, methodResponse);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    public ResponseDTO getPrototypeResponse(){
        ChoicesDTO choicesDTO = new ChoicesDTO(1, new MessageDTO("system", "Hello from AI"), "logprobs", "finisched");
        ChoicesDTO[] choices = new ChoicesDTO[1];
        choices[0] = choicesDTO;
        UsageDTO usageDTO = new UsageDTO(1, 1, 1);
        return new ResponseDTO("id", "object", 1, "model", choices, usageDTO);
    }
}
