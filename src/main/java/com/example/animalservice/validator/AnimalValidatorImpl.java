package com.example.animalservice.validator;

import com.example.animalservice.model.Animal;
import com.example.animalservice.model.sex.AnimalSex;
import com.example.animalservice.model.type.AnimalType;
import org.springframework.stereotype.Service;

@Service
public class AnimalValidatorImpl implements AnimalValidator {
    @Override
    public boolean isAnimalValid(Animal animal) {
        return animal.getName() != null && animal.getType() != null
                && animal.getSex() != null && animal.getWeight() != null
                && animal.getCost() != null && animal.getCategory() != null;
    }

    @Override
    public boolean isSexValid(String sex) {
        for (AnimalSex animalSex : AnimalSex.values()) {
            if (animalSex.name().toLowerCase().equals(sex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isTypeValid(String type) {
        for (AnimalType animalType : AnimalType.values()) {
            if (animalType.name().toLowerCase().equals(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCostValid(Integer cost) {
        return cost != null && cost >= 0;
    }

    @Override
    public boolean isWeightValid(Integer weight) {
        return weight != null && weight > 0;
    }

    @Override
    public boolean isNameValid(String name) {
        return name != null && !name.isBlank();
    }
}
