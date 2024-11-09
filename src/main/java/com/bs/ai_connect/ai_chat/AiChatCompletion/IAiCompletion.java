package com.bs.ai_connect.ai_chat.AiChatCompletion;

import com.bs.ai_connect.dto.QuestionDTO;

public interface IAiCompletion {
    String askAI(QuestionDTO question);
}
