package com.example.animalservice.repository.animal.provider;

import com.example.animalservice.model.Animal;
import com.example.animalservice.model.type.Type;
import com.example.animalservice.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TypeSpecificationProvider implements SpecificationProvider<Animal> {
    @Override
    public String getKey() {
        return "type";
    }

    public Specification<Animal> getSpecification(String... params) {
        return (root, query, criteriaBuilder) ->
                root.get("type").in(Arrays.stream(params).map(Type::new).toArray());
    }
}
