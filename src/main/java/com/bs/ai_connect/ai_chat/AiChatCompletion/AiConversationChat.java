package com.bs.ai_connect.ai_chat.AiChatCompletion;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.NoArgsConstructor;
import okhttp3.Request;
import okhttp3.ResponseBody;

@NoArgsConstructor
public class AiConversationChat extends AiChatCompletion{
    @Value("${env.data.maxTokens}")
    private int maxTokens;
    private int currentTokens;

    @Override
    public String askAi(String content) {
        if(super.isMockMode()){
            return "MockMode";
        }else{
            if(this.currentTokens + 200 >= this.maxTokens){
                super.getAiContext().summarizeMessages(super.getUserRole());
            }
            super.getAiContext().addMessage(new MessageDTO(super.getUserRole(), content));
            Request request = super.getAiRequester().requestBuilder(content);
            ResponseBody responseBody = super.getAiRequester().apiCall(request);
            String answer = "";
            if(responseBody != null) {
                answer = "Es ist etwas schief gegangen";
            }
            ResponseDTO response = null;
            try {
                response = AiResponseMapper.mapResponse(responseBody);
                answer = getResponseMsg(response);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateToken(response);
            return answer;
        }
        
    }

    private void updateToken(ResponseDTO response){
        this.currentTokens = response.usage().totalTokens();
    }
}
