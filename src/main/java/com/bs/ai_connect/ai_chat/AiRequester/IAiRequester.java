package com.bs.ai_connect.ai_chat.AiRequester;

import okhttp3.Request;
import okhttp3.ResponseBody;

public interface IAiRequester {
    Request requestBuilder(String question);
    ResponseBody apiCall(Request request);
}
