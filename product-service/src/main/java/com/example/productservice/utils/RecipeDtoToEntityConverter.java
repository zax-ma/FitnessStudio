package com.example.productservice.utils;

import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.recipe.RecipeDTO;
import org.springframework.core.convert.converter.Converter;

public class RecipeDtoToEntityConverter implements Converter<RecipeDTO, RecipeEntity> {
    @Override
    public RecipeEntity convert(RecipeDTO source) {
        return null;
    }
}
