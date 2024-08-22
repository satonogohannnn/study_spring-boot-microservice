package com.example.author_api.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HealthController.URL)
public class HealthController {
    
    public static final String URL = "/health";

    @GetMapping("")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Author API is up and running!");
    }
}
