package com.example.author_api.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.author_api.dtos.AuthorDto;
import com.example.author_api.dtos.CreateAuthorDto;
import com.example.author_api.dtos.UpdatedAuthorDto;
import com.example.author_api.models.AuthorModel;
import com.example.author_api.repositories.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository _authorRepository;

    @Override
    public List<AuthorDto> getAuthors() {
        List<AuthorModel> authors = _authorRepository.findAll();
        List<AuthorDto> authorDtos = authors.stream().map(authorItem -> new AuthorDto(
            authorItem.getId(),
            authorItem.getName(),
            authorItem.getDescription()
        )).toList();

        return authorDtos;
    }

    @Override
    public AuthorDto getAuthor(UUID id) {
        AuthorModel author = _findAuthorById(id);
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getDescription());
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorDto dto) {
        AuthorModel newAuthor = new AuthorModel();

        newAuthor.setName(dto.getName());
        newAuthor.setDescription(dto.getDescription());
        AuthorModel savedAuthor = _authorRepository.save(newAuthor);

        return new AuthorDto(
            savedAuthor.getId(),
            savedAuthor.getName(),
            savedAuthor.getDescription()
        );
    }

    @Override
    public void deleteAuthor(UUID id) {
        AuthorModel author = _findAuthorById(id);
        _authorRepository.delete(author);
    }

    @Override
    public void updateAuthor(UpdatedAuthorDto dto, UUID id) {
        AuthorModel found = _findAuthorById(id);

        if (Objects.nonNull(dto.getName())) {
            found.setName(dto.getName());
        }

        if (Objects.nonNull(dto.getDescription())) {
            found.setDescription(dto.getDescription());
        }

        _authorRepository.save(found);
    }

    private AuthorModel _findAuthorById(UUID id) {
        Optional<AuthorModel> result = _authorRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Not found with this ID" + id);
        }

        return result.get();
    }
    
}
