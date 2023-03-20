package com.example.productservice.dao.repo;

import com.example.productservice.dao.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRecipeRepository extends JpaRepository<RecipeEntity, UUID> {

    RecipeEntity findByTitle(String title);
    boolean existByTitle(String title);

}
