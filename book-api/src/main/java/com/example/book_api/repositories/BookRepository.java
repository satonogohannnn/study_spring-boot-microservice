package com.example.book_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book_api.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID> {

    
}