package com.example.animalservice.service;

import com.example.animalservice.dto.request.AnimalUploadRequestDto;
import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.dto.search.AnimalSearchParameters;
import java.util.List;

public interface AnimalService {
    List<AnimalResponseDto> saveAll(List<AnimalUploadRequestDto> animalUploadList);

    List<AnimalResponseDto> searchByParams(AnimalSearchParameters parameters);
}
