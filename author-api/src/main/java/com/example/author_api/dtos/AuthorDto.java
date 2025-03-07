package com.example.author_api.dtos;

import com.example.shared.DtoBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto extends DtoBase {
    
    private String name;
    private String description;
}
