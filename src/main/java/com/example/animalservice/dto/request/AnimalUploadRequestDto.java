package com.example.animalservice.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUploadRequestDto {
    @JsonProperty("Name")
    @JsonAlias("name")
    private String name;
    @JsonProperty("Type")
    @JsonAlias("type")
    private String type;
    @JsonProperty("Sex")
    @JsonAlias("sex")
    private String sex;
    @JsonProperty("Weight")
    @JsonAlias("weight")
    private Integer weight;
    @JsonProperty("Cost")
    @JsonAlias("cost")
    private Integer cost;
}
