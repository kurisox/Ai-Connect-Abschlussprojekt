package com.bs.ai_connect.ai_chat.AiChatCompletion;

import java.io.IOException;

import com.bs.ai_connect.dto.ContextDTO;
import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.QuestionDTO;
import com.bs.ai_connect.dto.ResponseDTO;
import com.bs.ai_connect.mapper.AiResponseMapper;
import com.bs.ai_connect.mapper.JavaToJSONMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.NoArgsConstructor;
import okhttp3.Request;
import okhttp3.ResponseBody;

@NoArgsConstructor
public class AiConversationChat extends AiChatCompletion implements IAiCompletion {

    private int currentTokens;

    @Override
    public String askAI(QuestionDTO question) {
        if (this.currentTokens + 200 >= super.getMaxTokens()) {
            int tokens = super.getAiContext().summarizeMessages(super.getUserRole());
            if (tokens == -1) {
                return super.getErrorMessage();
            }
        }
        super.getAiContext().addMessage(new MessageDTO(super.getUserRole(), question.question()));
        String mappedContext = "";
        try {
            mappedContext = JavaToJSONMapper.mapJSON(new ContextDTO(super.getModel(), super.getMaxTokens(), super.getAiContext().getMessages()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.getErrorMessage();
            
        }
        Request request = super.getAiRequester().requestBuilder(mappedContext);
        ResponseBody responseBody = super.getAiRequester().apiCall(request);
        String answer = "";
        if (responseBody != null) {
            return super.getErrorMessage();
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

    private void updateToken(ResponseDTO response) {
        this.currentTokens = response.usage().totalTokens();
    }
}
