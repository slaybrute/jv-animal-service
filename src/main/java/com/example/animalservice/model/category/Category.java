package com.example.animalservice.model.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "enum_value", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalCategory enumValue;
    @Column(name = "description", nullable = false)
    private String description;

    public Category(Integer id) {
        this.id = id;
    }
}
