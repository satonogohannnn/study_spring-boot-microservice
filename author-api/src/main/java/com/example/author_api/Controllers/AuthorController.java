package com.example.author_api.Controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = AuthorController.BASE_URL)
public class AuthorController {
    
    public static final String BASE_URL = "/api/v1/authors";

    @GetMapping("")
    public ResponseEntity<List<String>> getAuthors() {
        return ResponseEntity.ok(new ArrayList<String>(Arrays.asList("author 1", "author 2", "author 3")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAuthor(@PathVariable UUID id) {
        return ResponseEntity.ok("author 1");
    }

    @PostMapping("")
    public ResponseEntity<String> createAuthor(@Valid @RequestBody Object dto) {
        String newAuthor = "author 1";

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(UUID.randomUUID()).toUri();

        return ResponseEntity.created(location).body(newAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable UUID id) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable UUID id, @Valid @RequestBody Object dto) {
        return ResponseEntity.noContent().build();
    }
}