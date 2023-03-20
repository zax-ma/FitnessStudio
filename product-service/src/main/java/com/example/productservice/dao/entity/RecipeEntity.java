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
    @Column(name = "uuid")
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

    public RecipeEntity(UUID uuid,
                        LocalDateTime dt_create,
                        LocalDateTime dt_update,
                        String title,
                        List<IngredientEntity> composition) {
        this.uuid = uuid;
        this.dtCreate = dt_create;
        this.dtUpdate = dt_update;
        this.title = title;
        this.composition = composition;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDt_update() {
        return dtUpdate;
    }

    public void setDt_update(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
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
