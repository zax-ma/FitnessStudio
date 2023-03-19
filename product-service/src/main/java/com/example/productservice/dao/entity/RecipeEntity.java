package com.example.productservice.dao.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "app", name = "recipe")
public class RecipeEntity {
    @Id
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(
            schema = "app",
            name = "ingredients",
            joinColumns = @JoinColumn(name ="recipe_id" )
    )
    private List<IngredientEntity> composition;
}
