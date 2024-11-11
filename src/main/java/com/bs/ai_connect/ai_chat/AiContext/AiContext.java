package com.bs.ai_connect.ai_chat.AiContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.ai_chat.AiRequester.IAiRequester;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.Getter;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Getter
public class AiContext implements IAiContext{

    private List<MessageDTO> messages;

    private IAiRequester aiRequester;
    
    @Value("${env.data.aiPersona}")
    private String aiPersona;

    @Value("${env.data.role}")
    private String role;

    @Value("${env.data.summarizedMsg}")
    private String summarizeMsg;

    public AiContext(IAiRequester aiRequester){
        this.messages = new ArrayList<>();
        this.aiRequester = aiRequester;
    }

    @Override
    public boolean addMessage(MessageDTO message) {
        this.messages.add(message);
        return this.messages.contains(message);
    }

    @Override
    public int resetContent() {
        this.messages.clear();
        this.messages.add(new MessageDTO(this.role, this.aiPersona));
        return this.messages.size();
    }

    @Override
    public int summarizeMessages(String role) {
        ResponseDTO responseMessage = summarize(summarizeMsg);
        if(responseMessage == null){
            return -1;
        }
        this.messages.clear();
        this.messages.add(new MessageDTO(this.role, this.aiPersona + "\n" + responseMessage));
        return responseMessage.usage().completionTokens();
    }

    @Override
    public ResponseDTO summarize(String role) {
        Request summarizeRequest = aiRequester.requestBuilder(summarizeMsg);
        ResponseBody summarizeResponse = aiRequester.apiCall(summarizeRequest);
        try {
            return AiResponseMapper.mapResponse(summarizeResponse);
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
