package com.example.animalservice.repository.animal;

import com.example.animalservice.exception.SpecificationNotFoundException;
import com.example.animalservice.model.Animal;
import com.example.animalservice.repository.SpecificationProvider;
import com.example.animalservice.repository.SpecificationProviderManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalSpecificationProviderManager implements SpecificationProviderManager<Animal> {
    private final List<SpecificationProvider<Animal>> specifications;

    @Override
    public SpecificationProvider<Animal> getSpecification(String key) {
        for (SpecificationProvider<Animal> spec : specifications) {
            if (spec.getKey().equals(key)) {
                return spec;
            }
        }
        throw new SpecificationNotFoundException("Cannot find specification by key: " + key);
    }
}
