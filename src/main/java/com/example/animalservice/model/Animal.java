package com.example.animalservice.model;

import com.example.animalservice.model.category.Category;
import com.example.animalservice.model.sex.Sex;
import com.example.animalservice.model.type.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;
    @ManyToOne
    @JoinColumn(name = "sex_id", nullable = false)
    private Sex sex;
    @Column(name = "weight", nullable = false)
    private Integer weight;
    @Column(name = "cost", nullable = false)
    private Integer cost;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
