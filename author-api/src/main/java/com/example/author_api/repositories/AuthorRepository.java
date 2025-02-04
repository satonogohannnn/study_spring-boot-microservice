package com.example.author_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.author_api.models.AuthorModel;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
    
}
