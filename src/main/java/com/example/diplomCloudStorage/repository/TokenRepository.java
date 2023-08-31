package com.example.diplomCloudStorage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.diplomCloudStorage.entities.TokenEntity;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, String> {
}