package com.example.diplomCloudStorage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.diplomCloudStorage.dto.request.LoginInRequest;
import com.example.diplomCloudStorage.dto.response.LoginResponseDto;
import com.example.diplomCloudStorage.entities.TokenEntity;
import com.example.diplomCloudStorage.entities.UserEntity;
import com.example.diplomCloudStorage. exceptions.AuthorizationException;
import com.example.diplomCloudStorage.exceptions.BadCredentialsException;
import com.example.diplomCloudStorage.repository.TokenRepository;
import com.example.diplomCloudStorage.repository.UserRepository;

import java.util.Random;

@Service
public class AuthorizationService {
    private final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    private final Random random = new Random();

    public AuthorizationService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public LoginResponseDto login(LoginInRequest loginInRequest) {
        final String loginFromRequest = loginInRequest.getLogin();
        final UserEntity user = userRepository.findById(loginFromRequest).orElseThrow(() ->
                new BadCredentialsException("User with login " + loginFromRequest + " not found"));

        if (!user.getPassword().equals(loginInRequest.getPassword())) {
            throw new BadCredentialsException("Incorrect password for user " + loginFromRequest);
        }
        final String authToken = String.valueOf(random.nextLong());
        tokenRepository.save(new TokenEntity(authToken));
        logger.info("User " + loginFromRequest + " entered with token " + authToken);
        return new LoginResponseDto(authToken);
    }

    public void logout(String authToken) {
        tokenRepository.deleteById(authToken.split(" ")[1].trim());
    }

    public void checkToken(String authToken) {
        if (!tokenRepository.existsById(authToken.split(" ")[1].trim())) {
            throw new AuthorizationException();
        }
    }
}