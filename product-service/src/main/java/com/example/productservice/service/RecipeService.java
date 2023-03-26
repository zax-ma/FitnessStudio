package com.example.productservice.service;

import com.example.productservice.dao.entity.IngredientEntity;
import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dao.repo.IRecipeRepository;
import com.example.productservice.dto.AuxFieldsDTO;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.recipe.IngredientDTO;
import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.api.IProductService;
import com.example.productservice.service.api.IRecipeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class RecipeService implements IRecipeService {

    private final Converter<RecipeEntity, RecipeDTO> toDtoConverter;
    private final IRecipeRepository repository;
    private final IProductService productService;
    private final ConversionService conversionService;

    public RecipeService(Converter<RecipeEntity, RecipeDTO> toDtoConverter,
                         IRecipeRepository repository,
                         IProductService productService,
                         ConversionService conversionService) {
        this.toDtoConverter = toDtoConverter;
        this.repository = repository;
        this.productService = productService;
        this.conversionService = conversionService;
    }

    @Override
    public void create(NewRecipeDTO recipe) {
        if(recipe.getTitle().equals(this.repository.findByTitle(recipe.getTitle())) ){
            throw new RuntimeException("Recipe is already created");
        }
            this.repository.save(this.convertToEntity(recipe));
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
                .orElseThrow(() -> new EntityNotFoundException("uuid"));

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

    private RecipeEntity convertToEntity(NewRecipeDTO recipeCreateDTO) {

        RecipeEntity recipe = new RecipeEntity();
        AuxFieldsDTO aux = new AuxFieldsDTO();
        recipe.setUuid(aux.getUuid());
        recipe.setDt_create(aux.getDt_create());
        recipe.setDt_update(aux.getDt_update());
        recipe.setTitle(recipeCreateDTO.getTitle());
        List<IngredientDTO> ingredients = recipeCreateDTO.getComposition();
        List<IngredientEntity> productList = convertToProduct(ingredients);
        recipe.setComposition(productList);

        return recipe;
    }
}
