package com.example.animalservice.repository.animal.provider;

import com.example.animalservice.model.Animal;
import com.example.animalservice.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WeightSpecificationProvider implements SpecificationProvider<Animal> {
    @Override
    public String getKey() {
        return "weight";
    }

    public Specification<Animal> getSpecification(String... params) {
        return (root, query, criteriaBuilder) ->
                root.get("weight").in(Arrays.stream(params).map(Integer::parseInt).toArray());
    }
}
