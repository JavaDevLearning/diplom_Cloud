package com.example.diplomCloudStorage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.diplomCloudStorage.dto.request.LoginInRequest;
import com.example.diplomCloudStorage.dto.response.LoginResponseDto;
import com.example.diplomCloudStorage.service.AuthorizationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthorizationService authorizationService;

    public LoginController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping
    public LoginResponseDto login(@Valid @RequestBody LoginInRequest loginInRequest) {
        return authorizationService.login(loginInRequest);
    }
}