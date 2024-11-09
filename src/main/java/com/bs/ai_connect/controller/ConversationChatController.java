package com.bs.ai_connect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion.IAiCompletion;
import com.bs.ai_connect.dto.QuestionDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/conversation-chat")
public class ConversationChatController {
    private IAiCompletion aiCompletion;

    public ConversationChatController(IAiCompletion aiCompletion){
        this.aiCompletion = aiCompletion;
    }

    @PostMapping("/")
    public String postQuestion(@RequestBody QuestionDTO question) {
        String answer = aiCompletion.askAI(question);
        return answer;
    }

}
