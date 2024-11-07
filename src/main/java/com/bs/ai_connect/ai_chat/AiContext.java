package com.bs.ai_connect.ai_chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.MessageDTO;

public class AiContext {
    private List<MessageDTO> messages;
    
    @Value("${env.data.aiPersona}")
    private String aiPersona;

    public AiContext(){
        this.messages = new ArrayList<>();
    }

    public boolean addMessage(MessageDTO message){
        this.messages.add(message);
        return this.messages.contains(message);
    }

    public int resetContent(){
        return 0;
    }

    public int summarizeMessages(){
        return 1;
    }

    private String summarize(){
        return "";
    }
}
