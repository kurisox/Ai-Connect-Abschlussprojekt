package com.bs.ai_connect.ai_connector;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import okhttp3.OkHttpClient;

@Getter
public class AiConenctor {
    private static AiConenctor aiConenctor;
    private final OkHttpClient HTTP_CLIENT;
    private int timeout;

    private AiConenctor(){
        HTTP_CLIENT = new OkHttpClient.Builder().readTimeout(this.timeout, TimeUnit.SECONDS).build();
    }

    public static AiConenctor getInstance(){
        if(aiConenctor == null){
            aiConenctor = new AiConenctor();
        }
        return aiConenctor;
    }
}
