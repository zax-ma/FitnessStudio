package com.example.productservice.utils;

import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.recipe.RecipeDTO;
import org.springframework.core.convert.converter.Converter;

public class RecipeEntityToDtoConverter implements Converter<RecipeEntity, RecipeDTO> {
    @Override
    public RecipeDTO convert(RecipeEntity source) {
        return null;
    }
}
