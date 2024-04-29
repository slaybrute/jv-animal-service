package com.example.animalservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponseDto {
    private String name;
    private String type;
    private String sex;
    private Integer weight;
    private Integer cost;
    private Integer category;
}
