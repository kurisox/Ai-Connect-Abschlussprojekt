package com.bs.ai_connect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "object", "created", "model", "choices" })
public record ResponseDTO(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("created") long created,
        @JsonProperty("model") String model,
        @JsonProperty("choices") ChoicesDTO[] choices,
        @JsonProperty("usage") UsageDTO usage) {
}
