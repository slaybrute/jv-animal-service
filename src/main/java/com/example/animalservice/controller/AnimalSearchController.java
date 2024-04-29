package com.example.animalservice.controller;

import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.dto.search.AnimalSearchParameters;
import com.example.animalservice.service.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animals/search")
@RequiredArgsConstructor
public class AnimalSearchController {
    private final AnimalService animalService;

    @Operation(summary = "Get animals by search parameters",
            description = "Get list of animals by search params: "
                    + "{names, types, sexes, weights, costs}")
    @GetMapping
    public List<AnimalResponseDto> searchByParams(
            @ModelAttribute AnimalSearchParameters parameters) {
        return animalService.searchByParams(parameters);
    }
}
