package com.bs.ai_connect.mapper;

import com.bs.ai_connect.dto.ChoicesDTO;
import com.bs.ai_connect.dto.ContextDTO;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.dto.UsageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJSONMapper {
    private static JavaToJSONMapper javaToJSONMapper;
    private final ObjectMapper objectMapper;

    private JavaToJSONMapper(){
        this.objectMapper = new ObjectMapper();
    }

    public static JavaToJSONMapper getInstance(){
        if(javaToJSONMapper == null){
            javaToJSONMapper = new JavaToJSONMapper();
        }
        return javaToJSONMapper;
    }

    public static String mapJSON(ContextDTO contextDTO) throws JsonProcessingException {
        return getInstance().objectMapper.writeValueAsString(contextDTO);
    }
}
