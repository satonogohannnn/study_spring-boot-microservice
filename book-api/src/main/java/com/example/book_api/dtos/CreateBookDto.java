package com.example.book_api.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDto {
    
    @NotNull
    @Length(max = 50)
    public String title;

    @NotNull
    @Length(max = 250, min = 1)
    public String description;
}
