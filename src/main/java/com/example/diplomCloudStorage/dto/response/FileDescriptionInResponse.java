package com.example.diplomCloudStorage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDescriptionInResponse {
    private final String filename;
    private final int size;
}