package com.bs.ai_connect.mapper;

import java.io.IOException;

import com.bs.ai_connect.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.ResponseBody;

public class AiResponseMapper {
    private static AiResponseMapper aiResponseMapper;
    private final ObjectMapper objectMapper;

    private AiResponseMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public static AiResponseMapper getInstance() {
        if (aiResponseMapper == null) {
            aiResponseMapper = new AiResponseMapper();
        }
        return aiResponseMapper;
    }

    public static ResponseDTO mapResponse(ResponseBody responseBody)
            throws JsonMappingException, JsonProcessingException, IOException {
        ResponseDTO responseDTO = getInstance().objectMapper.readValue(responseBody.string(), ResponseDTO.class);
        return responseDTO;
    }
}
