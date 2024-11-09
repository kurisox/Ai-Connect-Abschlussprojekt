package com.bs.ai_connect.ai_chat.AiChatCompletion;

import java.io.IOException;

import com.bs.ai_connect.ai_chat.AiContext.IAiContext;
import com.bs.ai_connect.ai_chat.AiRequester.IAiRequester;
import com.bs.ai_connect.dto.ContextDTO;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.QuestionDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.bs.ai_connect.mapper.JavaToJSONMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import okhttp3.Request;
import okhttp3.ResponseBody;

public class AiSingleChat extends AiChatCompletion implements IAiCompletion{

    public AiSingleChat(IAiContext aiContext, IAiRequester aiRequester) {
        super(aiContext, aiRequester);
    }

    @Override
    public String askAI(QuestionDTO question) {
        super.getAiContext().addMessage(new MessageDTO(super.getUserRole(), question.question()));
        String mappedQuestion;
        
        try {
            mappedQuestion = JavaToJSONMapper.mapJSON(new ContextDTO(super.getModel(), super.getMaxTokens(), super.getAiContext().getMessages()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.getErrorMessage();
        }
        Request request = super.getAiRequester().requestBuilder(mappedQuestion);
        ResponseBody responsebody = super.getAiRequester().apiCall(request);
        String answer = "";
        if(responsebody != null) {
            return super.getErrorMessage();
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
