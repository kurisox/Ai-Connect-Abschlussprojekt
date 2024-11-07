package com.bs.ai_connect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "content", "role" })
public record MessageDTO(
        @JsonProperty("role") String role,
        @JsonProperty("content") String content) {
}
