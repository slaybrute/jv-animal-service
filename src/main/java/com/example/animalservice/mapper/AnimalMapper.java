package com.example.animalservice.mapper;

import com.example.animalservice.config.MapperConfig;
import com.example.animalservice.dto.request.AnimalUploadRequestDto;
import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.model.Animal;
import com.example.animalservice.model.category.Category;
import com.example.animalservice.model.sex.Sex;
import com.example.animalservice.model.type.Type;
import com.example.animalservice.validator.AnimalValidatorImpl;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface AnimalMapper {
    AnimalValidatorImpl ANIMAL_VALIDATOR = new AnimalValidatorImpl();

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "sex", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "weight", ignore = true)
    @Mapping(target = "cost", ignore = true)
    Animal toModel(AnimalUploadRequestDto animalUploadRequestDto);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "sex", ignore = true)
    @Mapping(target = "type", ignore = true)
    AnimalResponseDto toDto(Animal animal);

    @AfterMapping
    default void setName(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        String name = animalDto.getName();
        if (ANIMAL_VALIDATOR.isNameValid(name)) {
            animal.setName(name);
        }
    }

    @AfterMapping
    default void setWeight(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        Integer weight = animalDto.getWeight();
        if (ANIMAL_VALIDATOR.isWeightValid(weight)) {
            animal.setWeight(weight);
        }
    }

    @AfterMapping
    default void setCost(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        Integer cost = animalDto.getCost();
        if (ANIMAL_VALIDATOR.isCostValid(cost)) {
            animal.setCost(cost);
        }
    }

    @AfterMapping
    default void setCategory(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        Integer cost = animalDto.getCost();
        if (ANIMAL_VALIDATOR.isCostValid(cost)) {
            if (cost <= 20) {
                animal.setCategory(new Category(1));
            } else if (cost <= 40) {
                animal.setCategory(new Category(2));
            } else if (cost <= 60) {
                animal.setCategory(new Category(3));
            } else {
                animal.setCategory(new Category(4));
            }
        }
    }

    @AfterMapping
    default void setCategory(
            @MappingTarget AnimalResponseDto animalDto, Animal animal) {
        animalDto.setCategory(animal.getCategory().getId());
    }

    @AfterMapping
    default void setSex(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        String sex = animalDto.getSex();
        if (ANIMAL_VALIDATOR.isSexValid(sex)) {
            animal.setSex(new Sex(animalDto.getSex()));
        }
    }

    @AfterMapping
    default void setSex(
            @MappingTarget AnimalResponseDto animalDto, Animal animal) {
        animalDto.setSex(animal.getSex().getId());
    }

    @AfterMapping
    default void setType(
            @MappingTarget Animal animal, AnimalUploadRequestDto animalDto) {
        String type = animalDto.getType();
        if (ANIMAL_VALIDATOR.isTypeValid(type)) {
            animal.setType(new Type(animalDto.getType()));
        }
    }

    @AfterMapping
    default void setType(
            @MappingTarget AnimalResponseDto animalDto, Animal animal) {
        animalDto.setType(animal.getType().getId());
    }
}
