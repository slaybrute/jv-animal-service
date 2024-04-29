package com.example.animalservice.repository.animal;

import com.example.animalservice.dto.search.AnimalSearchParameters;
import com.example.animalservice.model.Animal;
import com.example.animalservice.repository.SpecificationBuilder;
import com.example.animalservice.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalSpecificationBuilder implements SpecificationBuilder<Animal> {
    private final SpecificationProviderManager<Animal> specProviderManager;

    @Override
    public Specification<Animal> build(AnimalSearchParameters animalSearchParameters) {
        Specification<Animal> spec = Specification.not(null);
        String[] names = animalSearchParameters.names();
        if (names != null && names.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("name").getSpecification(names));
        }
        String[] types = animalSearchParameters.types();
        if (types != null && types.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("type").getSpecification(types));
        }
        String[] sexes = animalSearchParameters.sexes();
        if (sexes != null && sexes.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("sex").getSpecification(sexes));
        }
        String[] costs = animalSearchParameters.costs();
        if (costs != null && costs.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("cost").getSpecification(costs));
        }
        String[] weights = animalSearchParameters.weights();
        if (weights != null && weights.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("weight")
                    .getSpecification(weights));
        }
        String[] categories = animalSearchParameters.categories();
        if (categories != null && categories.length > 0) {
            spec = spec.and(specProviderManager.getSpecification("category")
                    .getSpecification(categories));
        }
        return spec;
    }
}
