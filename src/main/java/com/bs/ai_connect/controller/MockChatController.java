package com.bs.ai_connect.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion.IAiCompletion;
import com.bs.ai_connect.dto.AnswerDTO;
import com.bs.ai_connect.dto.QuestionDTO;

@RestController
@RequestMapping("/api/mock-chat")
public class MockChatController {
    private IAiCompletion aiCompletion;

    public MockChatController(@Qualifier("mockChat") IAiCompletion aiCompletion){
        this.aiCompletion = aiCompletion;
    }

    @PostMapping("/")
    public AnswerDTO postQuestion(@RequestBody QuestionDTO question) {
        String answer = aiCompletion.askAI(question);
        return new AnswerDTO(answer);
    }
}
