package com.example.productservice.dto.recipe;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class IngredientDTO {

    @NonNull
    private UUID product;
    @NotEmpty
    private int weight;


    public IngredientDTO(@NonNull UUID product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    @NonNull
    public UUID getProduct() {
        return product;
    }

    public void setProduct(@NonNull UUID product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
