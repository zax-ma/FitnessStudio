package com.example.productservice.service;

import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.api.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.UUID;

public class RecipeService implements IRecipeService {
    @Override
    public void create(NewRecipeDTO recipe) {

    }

    @Override
    public Page<RecipeDTO> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public void update(UUID uuid, Timestamp dtUpdate, NewRecipeDTO recipe) {

    }
}
