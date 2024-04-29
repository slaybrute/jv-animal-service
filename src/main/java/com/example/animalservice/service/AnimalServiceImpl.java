package com.example.animalservice.service;

import com.example.animalservice.dto.request.AnimalUploadRequestDto;
import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.dto.search.AnimalSearchParameters;
import com.example.animalservice.mapper.AnimalMapper;
import com.example.animalservice.model.Animal;
import com.example.animalservice.repository.animal.AnimalRepository;
import com.example.animalservice.repository.animal.AnimalSpecificationBuilder;
import com.example.animalservice.validator.AnimalValidator;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalMapper animalMapper;
    private final AnimalRepository animalRepository;
    private final AnimalValidator animalValidator;
    private final AnimalSpecificationBuilder animalSpecBuilder;

    @Override
    public List<AnimalResponseDto> saveAll(List<AnimalUploadRequestDto> animalUploadList) {
        List<AnimalResponseDto> animalResponseList = new ArrayList<>(animalUploadList.size());
        for (AnimalUploadRequestDto animalUpload : animalUploadList) {
            Animal animal = animalMapper.toModel(animalUpload);
            if (animalValidator.isAnimalValid(animal)) {
                animalRepository.save(animal);
                animalResponseList.add(animalMapper.toDto(animal));
            }
        }
        return animalResponseList;
    }

    @Override
    public List<AnimalResponseDto> searchByParams(AnimalSearchParameters parameters) {
        Specification<Animal> spec = animalSpecBuilder.build(parameters);
        List<AnimalResponseDto> animalResponseList = new ArrayList<>();
        for (Animal animal : animalRepository.findAll(spec)) {
            animalResponseList.add(animalMapper.toDto(animal));
        }
        return animalResponseList;
    }
}
