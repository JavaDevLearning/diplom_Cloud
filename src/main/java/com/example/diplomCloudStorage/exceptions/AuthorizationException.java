package com.example.diplomCloudStorage.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("Пользователь не авторизован");
    }
}