package com.bs.ai_connect.ai_chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.MessageDTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AiContext {
    private List<MessageDTO> messages;
    
    @Value("${env.data.aiPersona}")
    private String aiPersona;

    public boolean addMessage(MessageDTO message){
        return true;
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
