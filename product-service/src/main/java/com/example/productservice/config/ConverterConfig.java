package com.example.productservice.config;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.dto.recipe.NewRecipeDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.api.IProductService;
import com.example.productservice.utils.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

public class ConverterConfig {
    @Bean
    public Converter<NewProductDTO, ProductEntity> newProductDtoToEntityConverter(){
        return new NewProductDtoToEntityConverter();
    }

    @Bean
    public Converter<ProductDTO, ProductEntity> productDTOProductEntityConverter(){
        return new ProductDtoToEntityConverter();
    }

    @Bean
    public Converter<ProductEntity, ProductDTO> productEntityProductDTOConverter(){
        return new ProductEntityToDtoConverter();
    }
    @Bean
    public Converter<RecipeEntity, RecipeDTO> recipeEntityRecipeDTOConverter(){
        return new RecipeEntityToDtoConverter();
    }

    @Bean
    public Converter<NewRecipeDTO, RecipeEntity> newRecipeDTORecipeEntityConverter(IProductService service){
        return new NewRecipeDtoToEntityConverter(service);
    }

}
