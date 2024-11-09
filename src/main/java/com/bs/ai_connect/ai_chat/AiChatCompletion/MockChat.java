package com.bs.ai_connect.ai_chat.AiChatCompletion;

public class MockChat implements IAiCompletion {

    @Override
    public String askAI(String question) {
        return question;
    }

}
