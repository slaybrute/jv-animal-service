package com.example.animalservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.animalservice.dto.search.AnimalSearchParameters;
import com.example.animalservice.dto.request.AnimalUploadRequestDto;
import java.util.Collections;
import java.util.List;
import com.example.animalservice.dto.response.AnimalResponseDto;
import com.example.animalservice.service.AnimalService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnimalServiceTest {
    private static final String INVALID_NAME = "   ";
    private static final String INVALID_TYPE = "dogg";
    private static final String INVALID_SEX = "males";
    private static final int INVALID_WEIGHT = 0;
    private static final int INVALID_COST = -1;

    private static List<AnimalUploadRequestDto> ALL_VALID_ANIMALS;
    private static AnimalUploadRequestDto INVALID_NAME_ANIMAL;
    private static AnimalUploadRequestDto INVALID_TYPE_ANIMAL;
    private static AnimalUploadRequestDto INVALID_SEX_ANIMAL;
    private static AnimalUploadRequestDto INVALID_WEIGHT_ANIMAL;
    private static AnimalUploadRequestDto INVALID_COST_ANIMAL;

    @Autowired
    private AnimalService animalService;

    @BeforeAll
    static void beforeAll() {
        ALL_VALID_ANIMALS = List.of(
                new AnimalUploadRequestDto("Lucy", "cat", "female", 10, 20),
                new AnimalUploadRequestDto("Beret", "dog", "male", 30, 21),
                new AnimalUploadRequestDto("Cari", "turtle", "female", 20, 41),
                new AnimalUploadRequestDto("Dorin", "ferret", "male", 15, 61)
        );
        INVALID_NAME_ANIMAL = new AnimalUploadRequestDto(INVALID_NAME, "dog", "male", 30, 21);
        INVALID_TYPE_ANIMAL = new AnimalUploadRequestDto("Waren", INVALID_TYPE, "female", 20, 15);
        INVALID_SEX_ANIMAL = new AnimalUploadRequestDto("Derik", "fish", INVALID_SEX, 20, 2);
        INVALID_WEIGHT_ANIMAL = new AnimalUploadRequestDto("Wornik", "snake", "female", INVALID_WEIGHT, 1);
        INVALID_COST_ANIMAL = new AnimalUploadRequestDto("Iren", "cat", "female", 5, INVALID_COST);
    }

    @Test
    void AllValidData_Ok() {
        List<AnimalResponseDto> expected = List.of(
                new AnimalResponseDto("Lucy", "cat", "female", 10, 20, 1),
                new AnimalResponseDto("Beret", "dog", "male", 30, 21, 2),
                new AnimalResponseDto("Cari", "turtle", "female", 20, 41, 3),
                new AnimalResponseDto("Dorin", "ferret", "male", 15, 61, 4)
        );
        assertEquals(expected, animalService.saveAll(ALL_VALID_ANIMALS));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchByNames("Lucy", "Beret", "Cari", "Dorin"));
        assertEquals(expected, actual);
    }

    @Test
    void invalidName_NotOk() {
        List<AnimalResponseDto> expected = Collections.emptyList();
        assertEquals(expected, animalService.saveAll(List.of(INVALID_NAME_ANIMAL)));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchByNames(INVALID_NAME));
        assertEquals(expected, actual);
    }


    @Test
    void invalidType_NotOk() {
        List<AnimalResponseDto> expected = Collections.emptyList();
        assertEquals(expected, animalService.saveAll(List.of(INVALID_TYPE_ANIMAL)));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchByTypes(INVALID_TYPE));
        assertEquals(expected, actual);
    }

    @Test
    void invalidSex_NotOk() {
        List<AnimalResponseDto> expected = Collections.emptyList();
        assertEquals(expected, animalService.saveAll(List.of(INVALID_SEX_ANIMAL)));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchBySexes(INVALID_SEX));
        assertEquals(expected, actual);
    }

    @Test
    void setInvalidWeight_NotOk() {
        List<AnimalResponseDto> expected = Collections.emptyList();
        assertEquals(expected,  animalService.saveAll(List.of(INVALID_WEIGHT_ANIMAL)));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchByWights(String.valueOf(INVALID_WEIGHT)));
        assertEquals(expected, actual);
    }

    @Test
    void setInvalidCost_NotOk() {
        List<AnimalResponseDto> expected = Collections.emptyList();
        assertEquals(expected, animalService.saveAll(List.of(INVALID_COST_ANIMAL)));
        List<AnimalResponseDto> actual = animalService.searchByParams(getSearchByCosts(String.valueOf(INVALID_COST)));
        assertEquals(expected, actual);
    }

    private AnimalSearchParameters getSearchByNames(String... names) {
        return new AnimalSearchParameters(
                names, null, null, null, null, null);
    }

    private AnimalSearchParameters getSearchByTypes(String... types) {
        return new AnimalSearchParameters(
                null, types , null, null, null, null);
    }

    private AnimalSearchParameters getSearchBySexes(String... sexes) {
        return new AnimalSearchParameters(
                null, null, sexes, null, null, null);
    }

    private AnimalSearchParameters getSearchByWights(String... weights) {
        return new AnimalSearchParameters(
                null, null, null, weights, null, null);
    }

    private AnimalSearchParameters getSearchByCosts(String... costs) {
        return new AnimalSearchParameters(
                null, null, null, null, costs, null);
    }
}
