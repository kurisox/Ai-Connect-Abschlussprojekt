package com.bs.ai_connect.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bs.ai_connect.ai_chat.AiChatCompletion.MockChat;

@Configuration
@Profile("mock")
public class Mock {

    @Bean(name = "mockChat")
    MockChat mockChat() {
        return new MockChat();
    }
}
