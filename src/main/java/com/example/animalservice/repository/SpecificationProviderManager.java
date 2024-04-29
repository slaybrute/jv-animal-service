package com.example.animalservice.repository;

public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecification(String key);
}
