package com.zemoga.portfoliowebapp.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponseDTO {

    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "access_token")
    private String accessToken;

    public String getToken() {
        return tokenType + " " + accessToken;
    }
}
