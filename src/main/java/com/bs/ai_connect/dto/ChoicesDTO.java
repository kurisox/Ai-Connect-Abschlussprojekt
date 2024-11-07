package com.bs.ai_connect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "index", "message", "logprobs", "finish_reason" })
public record ChoicesDTO(
        @JsonProperty("index") int index,
        @JsonProperty("message") MessageDTO message,
        @JsonProperty("logprobs") String logProbs,
        @JsonProperty("finish_reason") String finishReason) {
}
