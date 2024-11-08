package com.bs.ai_connect.ai_connector;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import okhttp3.OkHttpClient;

@Getter
public class AiConnector {
    private static AiConnector aiConenctor;
    private final OkHttpClient HTTP_CLIENT;

    @Value("${env.data.timeout}")
    private int timeout;

    private AiConnector(){
        HTTP_CLIENT = new OkHttpClient.Builder().readTimeout(this.timeout, TimeUnit.SECONDS).build();
    }

    public static AiConnector getInstance(){
        if(aiConenctor == null){
            aiConenctor = new AiConnector();
        }
        return aiConenctor;
    }
}
