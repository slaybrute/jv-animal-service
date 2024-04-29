package com.example.animalservice.controller;

import com.example.animalservice.dto.request.AnimalUploadRequestDto;
import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.service.AnimalService;
import com.example.animalservice.util.CsvUtils;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animals/files/uploads")
@RequiredArgsConstructor
public class AnimalUploadController {
    private final AnimalService animalService;

    @Operation(summary = "Upload animals from csv file",
            description = "Upload animal data from csv file to DB")
    @PostMapping("/csv")
    public List<AnimalResponseDto> upload(InputStream file) throws IOException {
        return animalService.saveAll(CsvUtils.read(AnimalUploadRequestDto.class, file));
    }

    @Operation(summary = "Upload animals from xml file",
            description = "Upload animal data from xml file to DB")
    @PostMapping("/xml")
    public List<AnimalResponseDto> upload(@RequestBody List<AnimalUploadRequestDto> animals) {
        return animalService.saveAll(animals);
    }
}
