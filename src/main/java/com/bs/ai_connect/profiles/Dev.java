package com.bs.ai_connect.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bs.ai_connect.ai_chat.AiChatCompletion.AiSingleChat;
import com.bs.ai_connect.ai_chat.AiChatCompletion.MockChat;
import com.bs.ai_connect.ai_chat.AiContext.AiContext;
import com.bs.ai_connect.ai_chat.AiRequester.AiRequester;

@Configuration
@Profile("dev")
public class Dev {

    @Bean(name = "aiSingleChat")
    AiSingleChat aiSingleChat() {
        return new AiSingleChat(new AiContext(new AiRequester()), new AiRequester());
    }

    @Bean(name = "aiConversationChat")
    AiSingleChat aiConversationChat() {
        return new AiSingleChat(new AiContext(new AiRequester()), new AiRequester());
    }

    @Bean(name = "mockChat")
    MockChat mockChat() {
        return new MockChat();
    }

}
