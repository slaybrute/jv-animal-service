package com.example.animalservice.repository.animal.provider;

import com.example.animalservice.model.Animal;
import com.example.animalservice.model.category.Category;
import com.example.animalservice.repository.SpecificationProvider;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CategorySpecificationProvider implements SpecificationProvider<Animal> {
    @Override
    public String getKey() {
        return "category";
    }

    @Override
    public Specification<Animal> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get("category").in(Arrays.stream(params).map(p -> {
                    try {
                        return new Category(Integer.parseInt(p));
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }).filter(Objects::nonNull).toArray());
    }
}
