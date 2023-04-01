package com.example.productservice.service;

import com.example.productservice.dao.entity.IngredientEntity;
import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dao.repo.IRecipeRepository;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.recipe.IngredientDTO;
import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.api.IProductService;
import com.example.productservice.service.api.IRecipeService;
import com.example.productservice.utils.exceptions.RecipeExistException;
import com.example.productservice.utils.exceptions.RecipeNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class RecipeService implements IRecipeService {

    private final Converter<RecipeEntity, RecipeDTO> toDtoConverter;
    private final IRecipeRepository repository;
    private final IProductService productService;

    public RecipeService(Converter<RecipeEntity, RecipeDTO> toDtoConverter,
                         IRecipeRepository repository,
                         IProductService productService) {
        this.toDtoConverter = toDtoConverter;
        this.repository = repository;
        this.productService = productService;

    }

    @Override
    public void create(RecipeEntity recipe) {
        if(recipe.getTitle().equals(this.repository.findByTitle(recipe.getTitle())) ){
            throw new RecipeExistException("Recipe is already created");
        }
            this.repository.save(recipe);
    }

    @Override
    public PageDTO<RecipeDTO> getPage(Pageable pageable) {

        Page<RecipeEntity> recipeEntityPage = this.repository.findAll(pageable);
        List<RecipeDTO> content = new ArrayList<>();

        for (RecipeEntity recipeEntity : recipeEntityPage){
            content.add(this.toDtoConverter.convert(recipeEntity));
        }
        return new PageDTO<>(
                recipeEntityPage.getNumber(),
                recipeEntityPage.getSize(),
                recipeEntityPage.getTotalPages(),
                recipeEntityPage.getTotalElements(),
                recipeEntityPage.isFirst(),
                recipeEntityPage.getNumberOfElements(),
                recipeEntityPage.isLast(),
                content);
    }

    @Override
    public void update(UUID id, Timestamp dt_update, NewRecipeDTO recipe) {
        RecipeEntity recipeUpdate = this.repository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe " + id +"was not found"));

        if (Timestamp.valueOf(recipeUpdate.getDt_update()).equals(dt_update)){
            List<IngredientEntity> ingredient = convertToProduct(recipe.getComposition());
            recipeUpdate.setTitle(recipe.getTitle());
            recipeUpdate.setComposition(ingredient);
            this.repository.save(recipeUpdate);
        }
    }

    private List<IngredientEntity> convertToProduct(
            List<IngredientDTO> ingredients) {

        return ingredients.stream()
                .map(dto -> {
                    ProductEntity product = this.productService.getById(dto.getProduct());
                    IngredientEntity ingredient = new IngredientEntity();

                    ingredient.setProductEntity(product);
                    ingredient.setWeight(dto.getWeight());

                    return ingredient;
                })
                .collect(Collectors.toList());
    }

}
