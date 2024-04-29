package com.example.animalservice.repository;

import com.example.animalservice.dto.search.AnimalSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(AnimalSearchParameters animalSearchParameters);
}
