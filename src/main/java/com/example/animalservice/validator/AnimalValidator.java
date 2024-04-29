package com.example.animalservice.validator;

import com.example.animalservice.model.Animal;

public interface AnimalValidator {
    boolean isAnimalValid(Animal animal);

    boolean isSexValid(String sex);

    boolean isTypeValid(String type);

    boolean isCostValid(Integer cost);

    boolean isWeightValid(Integer weight);

    boolean isNameValid(String name);
}
