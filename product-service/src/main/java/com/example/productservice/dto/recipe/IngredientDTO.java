package com.example.productservice.dto.recipe;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class IngredientDTO {

    @NotNull
    private UUID product;
    @NotEmpty
    private int weight;


    public IngredientDTO(@NotNull UUID product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    @NotNull
    public UUID getProduct() {
        return product;
    }

    public void setProduct(@NotNull UUID product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
