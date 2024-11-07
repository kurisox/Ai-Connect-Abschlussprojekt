package com.bs.ai_connect.ai_chat;

import org.springframework.beans.factory.annotation.Value;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AiConversationChat extends AiChatCompletion{
    @Value("${env.data.maxTokens}")
    private int maxTokens;
    private int currentTokens;

    @Override
    public String askAi(String content) {
        return "";
    }

    private int updateToken(){
        return 1;
    }



}
