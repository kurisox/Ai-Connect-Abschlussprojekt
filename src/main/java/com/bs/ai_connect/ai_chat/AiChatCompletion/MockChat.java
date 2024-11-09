package com.bs.ai_connect.ai_chat.AiChatCompletion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bs.ai_connect.dto.QuestionDTO;

@Component
public class MockChat implements IAiCompletion {
    @Value("${env.data.shortAnswer}")
    private String shortAnswer;

    @Value("${env.data.longAnswer}")    
    private String longAnswer;

    @Override
    public String askAI(QuestionDTO question) {
        if (question.question().equals("1")) {
            return shortAnswer;
        } else {
            return longAnswer;
        }
    }

}
