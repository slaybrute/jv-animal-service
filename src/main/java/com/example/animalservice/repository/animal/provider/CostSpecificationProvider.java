package com.example.animalservice.repository.animal.provider;

import com.example.animalservice.model.Animal;
import com.example.animalservice.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CostSpecificationProvider implements SpecificationProvider<Animal> {
    @Override
    public String getKey() {
        return "cost";
    }

    public Specification<Animal> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get("cost").in(Arrays.stream(params).map(Integer::parseInt).toArray());
    }
}
