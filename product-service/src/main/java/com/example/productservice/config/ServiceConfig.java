package com.example.productservice.config;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dao.repo.IProductRepository;
import com.example.productservice.dao.repo.IRecipeRepository;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.RecipeService;
import com.example.productservice.service.api.IProductService;
import com.example.productservice.service.api.IRecipeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ServiceConfig {
    public IProductService productService(IProductRepository repository,
                                            Converter<ProductEntity, ProductDTO> toDtoConverter){

        return new ProductService(repository, toDtoConverter);
    }

    public IRecipeService recipeService(Converter<RecipeEntity, RecipeDTO> toDtoConverter,
                                        IRecipeRepository repository,
                                        IProductService productService){
        return new RecipeService(toDtoConverter,repository,productService);
    }

}
