package com.example.productservice.utils;

import com.example.productservice.dao.entity.IngredientEntity;
import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.AuxFieldsDTO;
import com.example.productservice.dto.recipe.IngredientDTO;
import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewRecipeDtoToEntityConverter implements Converter<NewRecipeDTO, RecipeEntity> {

    IProductService productService;

    @Autowired
    public NewRecipeDtoToEntityConverter(IProductService productService) {
        this.productService = productService;
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

    @Override
    public RecipeEntity convert(NewRecipeDTO source) {
        RecipeEntity recipe = new RecipeEntity();
        AuxFieldsDTO aux = new AuxFieldsDTO();
        recipe.setUuid(aux.getUuid());
        recipe.setDt_create(aux.getDt_create());
        recipe.setDt_update(aux.getDt_update());
        recipe.setTitle(source.getTitle());
        List<IngredientDTO> ingredients = source.getComposition();
        List<IngredientEntity> productList = convertToProduct(ingredients);

        recipe.setComposition(productList);

        return recipe;
    }

}
