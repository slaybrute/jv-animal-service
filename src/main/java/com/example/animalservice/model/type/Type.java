package com.example.animalservice.model.type;

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
@Table(name = "types")
@NoArgsConstructor
public class Type {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_value", nullable = false)
    private AnimalType enumValue;

    public Type(String id) {
        this.id = id;
    }
}
