package com.bs.ai_connect.ai_chat;

import org.springframework.beans.factory.annotation.Value;

import lombok.NoArgsConstructor;
import okhttp3.Request;
import okhttp3.ResponseBody;

@NoArgsConstructor
public class AiRequester {
    @Value("${env.data.devMode}")
    private boolean devMode;

    @Value("${env.data.api_endpoint}")
    private String api_endpoint;

    @Value("${env.data.content_type}")
    private String content_type ;

    @Value("${env.data.json}")
    private String json;

    public Request requestBuilder(String content){
        return null;
    }

    public ResponseBody apiCall(Request request){
        return null;
    }
}
