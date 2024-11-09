package com.bs.ai_connect.ai_chat.AiRequester;

import org.springframework.beans.factory.annotation.Value;

import com.bs.ai_connect.ai_connector.AiConnector;

import lombok.Getter;
import lombok.NoArgsConstructor;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Getter
public class AiRequester implements IAiRequester {
    @Value("${env.data.mockMode}")
    private boolean mockMode;

    @Value("${env.data.api_endpoint}")
    private String api_endpoint;

    @Value("${env.data.content_type}")
    private String content_type;

    @Value("${env.data.json}")
    private String json;

    public Request requestBuilder(String content) {
        System.out.println(content_type);
        RequestBody requestBody = RequestBody.create(content, MediaType.parse(content_type));
        Request request = new Request.Builder()
                .url(api_endpoint)
                .header(content_type, json)
                .post(requestBody)
                .build();
        return request;
    }

    public ResponseBody apiCall(Request request) {
        Call call = AiConnector.getInstance().getHTTP_CLIENT().newCall(request);
        try {
            Response response = call.execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
