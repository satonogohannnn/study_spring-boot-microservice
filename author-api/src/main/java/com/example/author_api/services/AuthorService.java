package com.example.author_api.services;

import java.util.List;
import java.util.UUID;

import com.example.author_api.dtos.AuthorDto;
import com.example.author_api.dtos.CreateAuthorDto;
import com.example.author_api.dtos.UpdatedAuthorDto;

public interface AuthorService {
    
    public List<AuthorDto> getAuthors();

    public AuthorDto getAuthor(UUID id);

    public AuthorDto createAuthor(CreateAuthorDto dto);

    public void deleteAuthor(UUID id);

    public void updateAuthor(UpdatedAuthorDto dto, UUID id);
}
