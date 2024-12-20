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
@RequestMapping("/api/single-chat")
public class SingleChatController {

    private IAiCompletion aiCompletion;

    public SingleChatController(@Qualifier("aiSingleChat") IAiCompletion aiCompletion){
        this.aiCompletion = aiCompletion;
    }
    
    @PostMapping("/")
    public AnswerDTO postAnswer(@RequestBody QuestionDTO question){
        String answer = aiCompletion.askAI(question);
        return new AnswerDTO(answer);
    }

}
