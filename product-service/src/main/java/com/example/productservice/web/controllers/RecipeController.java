package com.example.productservice.web.controllers;

import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.recipe.RecipeDTO;
import org.springframework.core.convert.converter.Converter;

public class RecipeController {
    Converter<RecipeDTO, RecipeEntity> toEntityConverter;

}
