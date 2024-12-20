package com.bs.ai_connect.ai_chat.AiChatCompletion;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.ai_chat.AiContext.IAiContext;
import com.bs.ai_connect.ai_chat.AiRequester.IAiRequester;
import com.bs.ai_connect.dto.ResponseDTO;

import lombok.Getter;

@Getter
public abstract class AiChatCompletion {
    private IAiContext aiContext;
    private IAiRequester aiRequester;
    
    @Value("${env.data.maxTokens}")
    private int maxTokens;
    
    @Value("${env.data.errorMsg}")
    private String errorMessage;

    @Value("${env.data.model}")
    private String model;

    @Value("${env.data.userRole}")
    private String userRole;

    public AiChatCompletion(IAiContext aiContext, IAiRequester aiRequester){
        this.aiContext = aiContext;
        this.aiRequester = aiRequester;
    }

    protected String getResponseMsg(ResponseDTO response){
        return response.choices()[0].message().content();
    }
}
