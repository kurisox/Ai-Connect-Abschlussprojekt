package com.bs.ai_connect.ai_chat;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.ResponseDTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AiChatCompletion {
    private AiContext aiContext;
    private AiRequester aiRequester;
    
    @Value("${env.data.mockMode}")
    private boolean mockMode;

    public abstract String askAi(String content);

    public String getResponseMsg(ResponseDTO reponse){
        return "";
    }
}
