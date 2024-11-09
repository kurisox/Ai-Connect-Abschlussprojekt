package com.bs.ai_connect.ai_chat.AiContext;

import com.bs.ai_connect.dto.MessageDTO;
import com.bs.ai_connect.dto.ResponseDTO;

public interface IAiContext {

    boolean addMessage(MessageDTO message);
    int resetContent();
    int summarizedMessages(String role);
    ResponseDTO summarize(String role);
}
