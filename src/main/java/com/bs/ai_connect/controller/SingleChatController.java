package com.bs.ai_connect.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion.AiChatCompletion;
import com.bs.ai_connect.ai_chat.AiChatCompletion.AiConversationChat;
import com.bs.ai_connect.ai_chat.AiChatCompletion.AiSingleChat;
import com.bs.ai_connect.ai_chat.AiChatCompletion.IAiCompletion;
import com.bs.ai_connect.ai_chat.AiChatCompletion.MockChat;


@RestController
@RequestMapping("/api/single-chat")
public class SingleChatController {

    private IAiCompletion aiCompletion;

    @Value("${env.data.mockMode}")
    private boolean mockMode;

    public SingleChatController() {
        if(mockMode){
            this.aiCompletion = new MockChat();
        } else {
            this.aiCompletion = new AiSingleChat();
        }               
    }

    @PostMapping("/")
    public String postAnswer(@RequestParam String question){
        String answer = aiCompletion.askAI(question);
        return answer;
    }

}
