package com.bs.ai_connect.ai_chat;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.ResponseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public abstract class AiChatCompletion {
    private AiContext aiContext;
    private AiRequester aiRequester;
    
    @Value("${env.data.mockMode}")
    private boolean mockMode;

    @Value("${env.data.userRole}")
    private String userRole;

    public abstract String askAi(String content);

    protected String getResponseMsg(ResponseDTO response){
        return response.choices()[0].message().content();
    }
}
