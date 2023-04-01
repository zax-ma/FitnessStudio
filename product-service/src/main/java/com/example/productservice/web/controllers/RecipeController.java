package com.example.productservice.web.controllers;

import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.api.IRecipeService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    IRecipeService service;

    Converter<NewRecipeDTO, RecipeEntity> converter;


    public RecipeController(IRecipeService service, Converter<NewRecipeDTO, RecipeEntity> converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody NewRecipeDTO recipe) {
        this.service.create(this.converter.convert(recipe));
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public PageDTO<RecipeDTO> getRecipePage(Pageable pageable) {
        return this.service.getPage(pageable);
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<String> updateRecipe(@PathVariable("uuid") UUID uuid,
                                             @PathVariable("dt_update") Timestamp dt_update,
                                             @RequestBody NewRecipeDTO product) {

        this.service.update(uuid, dt_update, product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
