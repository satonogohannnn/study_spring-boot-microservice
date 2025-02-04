package com.example.author_api.dtos;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedAuthorDto {

    @Length(max = 50)
    private String name;

    @Length(max = 255)
    private String description;
}
