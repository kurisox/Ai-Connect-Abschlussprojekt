package com.bs.ai_connect.ai_chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.MessageDTO;

import lombok.Getter;

@Getter
public class AiContext {

    @Value("${env.data.mockMode}")
    private boolean mockMode;

    private List<MessageDTO> messages;
    
    @Value("${env.data.aiPersona}")
    private String aiPersona;

    @Value("${env.data.role}")
    private String role;

    @Value("${env.data.summarizeMsg}")
    private String summarizeMsg;

    public AiContext(){
        this.messages = new ArrayList<>();
    }

    public boolean addMessage(MessageDTO message){
        this.messages.add(message);
        return this.messages.contains(message);
    }

    public int resetContent(){
        this.messages.clear();
        this.messages.add(new MessageDTO(this.role, this.aiPersona));
        return this.messages.size();
    }

    public int summarizeMessages(String role){
        return 1;
    }

    private String summarize(String role){
        return "";
    }
}
