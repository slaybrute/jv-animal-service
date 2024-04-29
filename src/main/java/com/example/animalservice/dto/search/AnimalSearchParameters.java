package com.example.animalservice.dto.search;

public record AnimalSearchParameters(String[] names, String[] types, String[] sexes,
                                     String[] weights, String[] costs, String[] categories) {
}
