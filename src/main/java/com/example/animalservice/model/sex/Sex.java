package com.example.animalservice.model.sex;

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
@Table(name = "sexes")
@NoArgsConstructor
public class Sex {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "enum_value", nullable = false)
    private AnimalSex enumValue;

    public Sex(String id) {
        this.id = id;
    }
}
