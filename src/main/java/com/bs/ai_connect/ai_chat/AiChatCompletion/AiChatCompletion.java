package com.bs.ai_connect.ai_chat.AiChatCompletion;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.ai_chat.AiContext.AiContext;
import com.bs.ai_connect.ai_chat.AiRequester.AiRequester;
import com.bs.ai_connect.dto.ResponseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public abstract class AiChatCompletion {
    private AiContext aiContext;
    private AiRequester aiRequester;
    
    @Value("${env.data.maxTokens}")
    private int maxTokens;
    
    @Value("${env.data.errorMsg}")
    private String errorMessage;

    @Value("${env.data.model}")
    private String model;


    @Value("${env.data.userRole}")
    private String userRole;

    protected String getResponseMsg(ResponseDTO response){
        return response.choices()[0].message().content();
    }
}
