package com.example.animalservice.repository.animal.provider;

import com.example.animalservice.model.Animal;
import com.example.animalservice.model.sex.Sex;
import com.example.animalservice.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class SexSpecificationProvider implements SpecificationProvider<Animal> {
    @Override
    public String getKey() {
        return "sex";
    }

    public Specification<Animal> getSpecification(String... params) {
        return (root, query, criteriaBuilder) ->
                root.get("sex").in(Arrays.stream(params).map(Sex::new).toArray());
    }
}
