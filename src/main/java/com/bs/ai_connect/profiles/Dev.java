package com.bs.ai_connect.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

import com.bs.ai_connect.ai_chat.AiChatCompletion.AiSingleChat;
import com.bs.ai_connect.ai_chat.AiChatCompletion.MockChat;
import com.bs.ai_connect.ai_chat.AiContext.AiContext;
import com.bs.ai_connect.ai_chat.AiRequester.AiRequester;

@Configuration
@Profile("dev")
public class Dev {

    @Bean(name = "aiRequester")
    AiRequester aiRequester() {
        return new AiRequester();
    }

    @Bean(name = "aiContext")
    @DependsOn("aiRequester")
    AiContext aiContext() {
        return new AiContext(aiRequester());
    }

    @Bean(name = "aiSingleChat")
    @DependsOn("aiContext")
    AiSingleChat aiSingleChat() {
        return new AiSingleChat(aiContext(), aiRequester());
    }

    @Bean(name = "aiConversationChat")
    @DependsOn("aiContext")
    AiSingleChat aiConversationChat() {
        return new AiSingleChat(aiContext(), aiRequester());
    }

    @Bean(name = "mockChat")
    MockChat mockChat() {
        return new MockChat();
    }

}
