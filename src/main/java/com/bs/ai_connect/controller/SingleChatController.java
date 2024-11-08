package com.bs.ai_connect.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion;
import com.bs.ai_connect.ai_chat.AiSingleChat;


@RestController
@RequestMapping("/api/simple-answer")
public class SingleChatController {

    private AiChatCompletion simpleAnswer;

    public SingleChatController(){
        this.simpleAnswer = new AiSingleChat();
    }

    @PostMapping("/")
    public String postAnswer(@RequestParam String question){
        String answer = simpleAnswer.askAi(question);
        return answer;
    }

}
