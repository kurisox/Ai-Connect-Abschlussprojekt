package com.bs.ai_connect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion.AiConversationChat;
import com.bs.ai_connect.ai_chat.AiChatCompletion.IAiCompletion;
import com.bs.ai_connect.ai_chat.AiChatCompletion.MockChat;
import com.bs.ai_connect.dto.QuestionDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/conversation-chat")
public class ConversationChatController {
    private IAiCompletion aiCompletion;

    @Value("${env.data.mockMode}")
    private boolean mockMode;

    public ConversationChatController() {
        if(mockMode){
            this.aiCompletion = new MockChat();
        } else {
            this.aiCompletion = new AiConversationChat();
        }               
    }

    @PostMapping("/")
    public String postQuestion(@RequestBody QuestionDTO question) {
        String answer = aiCompletion.askAI(question);
        return answer;
    }

}
