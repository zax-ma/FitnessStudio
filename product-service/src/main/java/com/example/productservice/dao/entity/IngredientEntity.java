package com.example.productservice.dao.entity;

import jakarta.persistence.*;



@Embeddable
@Table(schema = "app", name = "ingredients")
public class IngredientEntity {

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false, updatable = false
    )
    private ProductEntity productEntity;

    @Column(name = "weight")
    private int weight;

    public IngredientEntity() {
    }

    public IngredientEntity(ProductEntity productEntity, int weight) {
        this.productEntity = productEntity;
        this.weight = weight;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}