package com.bs.ai_connect.ai_chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.Getter;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Getter
public class AiContext {

    @Value("${env.data.mockMode}")
    private boolean mockMode;

    private List<MessageDTO> messages;

    private AiRequester aiRequester;
    
    @Value("${env.data.aiPersona}")
    private String aiPersona;

    @Value("${env.data.role}")
    private String role;

    @Value("${env.data.summarizeMsg}")
    private String summarizeMsg;

    public AiContext(){
        this.messages = new ArrayList<>();
        this.aiRequester = new AiRequester();
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
        int listSize;
        String responseMessage = "Context wurde zusammengefasst";
        if(!this.mockMode){
            responseMessage = summarize(role);
            if(responseMessage == null){
                return -1;
            }
        }
        this.messages.clear();
        this.messages.add(new MessageDTO(this.role, this.aiPersona + "\n" + responseMessage));
        listSize = this.messages.size();
        return listSize;
    }

    private String summarize(String role){
        Request summarizeRequest = aiRequester.requestBuilder(summarizeMsg);
        ResponseBody summarizeResponse = aiRequester.apiCall(summarizeRequest);
        ResponseDTO responseDTO;
        try {
            responseDTO = AiResponseMapper.mapResponse(summarizeResponse);
            return responseDTO.choices()[0].message().content();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
