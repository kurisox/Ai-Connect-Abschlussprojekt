package com.bs.ai_connect.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "model", "max_tokens", "messages" })
public record ContextDTO(
        @JsonProperty("model") String model,
        @JsonProperty("max_tokens") int max_tokens,
        @JsonProperty("messages") List<MessageDTO> messages) {
}
