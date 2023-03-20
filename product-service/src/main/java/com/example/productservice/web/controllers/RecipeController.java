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

    public RecipeController(IRecipeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody NewRecipeDTO recipe) {
        this.service.create(recipe);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping
    public PageDTO<RecipeDTO> getUserPage(Pageable pageable) {
        return this.service.getPage(pageable);
    }

    @PutMapping("/{uuid}/dt_update/{lastUpdated}")
    public ResponseEntity<String> updateUser(@PathVariable UUID uuid,
                                             @PathVariable Timestamp lst_updated,
                                             @RequestBody NewRecipeDTO product) {

        this.service.update(uuid, lst_updated, product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
