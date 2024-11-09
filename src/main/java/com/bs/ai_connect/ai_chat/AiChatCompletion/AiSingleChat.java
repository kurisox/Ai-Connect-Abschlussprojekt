package com.bs.ai_connect.ai_chat.AiChatCompletion;

import java.io.IOException;

import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.NoArgsConstructor;
import okhttp3.Request;
import okhttp3.ResponseBody;

@NoArgsConstructor
public class AiSingleChat extends AiChatCompletion{

    @Override
    public String askAi(String content) {
        super.getAiContext().addMessage(new MessageDTO(super.getUserRole(), content));
        Request request = super.getAiRequester().requestBuilder(content);
        ResponseBody responsebody = super.getAiRequester().apiCall(request);
        String answer = "";
        if(responsebody != null) {
            answer = "Es ist etwas schief gegangen";
        }
        try {
            ResponseDTO response = AiResponseMapper.mapResponse(responsebody);
            answer = getResponseMsg(response);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

}
