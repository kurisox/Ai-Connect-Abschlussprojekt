package com.bs.ai_connect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.ai_connect.ai_chat.AiChatCompletion;
import com.bs.ai_connect.ai_chat.AiConversationChat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/conversation-chat")
public class ConversationChatController {
    private AiChatCompletion conversationAnswer;

    public ConversationChatController() {
        this.conversationAnswer = new AiConversationChat();
    }

    @PostMapping("/")
    public String postAnsq(@RequestBody String question) {
        String answer = conversationAnswer.askAi(question);
        return answer;
    }

}
