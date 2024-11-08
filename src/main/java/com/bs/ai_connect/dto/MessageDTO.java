package com.bs.ai_connect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"role", "content" })
public record MessageDTO(
        @JsonProperty("role") String role,
        @JsonProperty("content") String content) {
}
