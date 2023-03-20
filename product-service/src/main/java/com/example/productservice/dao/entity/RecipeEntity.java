package com.example.productservice.dao.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "app", name = "recipe")
public class RecipeEntity {
    @Id
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "dt_create")
    private LocalDateTime dt_create;

    @Column(name = "dt_update")
    private LocalDateTime dt_update;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(
            schema = "app",
            name = "ingredients",
            joinColumns = @JoinColumn(name ="recipe_id" )
    )
    private List<IngredientEntity> composition;

    public RecipeEntity() {
    }

    public RecipeEntity(UUID uuid,
                        LocalDateTime dt_create,
                        LocalDateTime dt_update,
                        String title,
                        List<IngredientEntity> composition) {
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.title = title;
        this.composition = composition;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setDt_create(LocalDateTime dtCreate) {
        this.dt_create = dtCreate;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dtUpdate) {
        this.dt_update = dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientEntity> getComposition() {
        return composition;
    }

    public void setComposition(List<IngredientEntity> composition) {
        this.composition = composition;
    }
}
