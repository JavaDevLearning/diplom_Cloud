package com.example.diplomCloudStorage.dto.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String authToken;

    @JsonGetter("auth-token")
    public String getAuthToken() {
        return authToken;
    }
}