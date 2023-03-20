package com.example.productservice.dto.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RecipeDTO {

    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("dt_create")
    private LocalDateTime dt_create;

    @JsonProperty("dt_update")
    private LocalDateTime dt_update;

    @JsonProperty("title")
    private String title;

    @JsonProperty("composition")
    private List<CompositionDTO> composition;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("calories")
    private int calories;

    @JsonProperty("proteins")
    private double proteins;

    @JsonProperty("fats")
    private double fats;

    @JsonProperty("carbohydrates")
    private double carbohydrates;

    public RecipeDTO() {
    }

    public RecipeDTO(UUID uuid, LocalDateTime dt_create, LocalDateTime dt_update, String title, List<CompositionDTO> composition, int weight, int calories, double proteins, double fats, double carbohydrates) {
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.title = title;
        this.composition = composition;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
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

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CompositionDTO> getComposition() {
        return composition;
    }

    public void setComposition(List<CompositionDTO> composition) {
        this.composition = composition;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
