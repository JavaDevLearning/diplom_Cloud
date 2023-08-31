package com.example.diplomCloudStorage.repository;

import com.example.diplomCloudStorage.entities.FileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface FileRepository extends CrudRepository<FileEntity, String> {
    @Query(value = "SELECT * FROM files LIMIT :limit", nativeQuery = true)
    List<FileEntity> getFiles(int limit);
}