package com.example.productservice.utils.converters;

import com.example.productservice.dao.entity.IngredientEntity;
import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.AuxFieldsDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.dto.recipe.CompositionDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeEntityToDtoConverter implements Converter<RecipeEntity, RecipeDTO> {
    private Converter<ProductEntity, ProductDTO> productToDTOConverter;
    private List<CompositionDTO> productComposition;

    public RecipeEntityToDtoConverter() {
    }

    public RecipeEntityToDtoConverter(Converter<ProductEntity, ProductDTO> productToDTOConverter, List<CompositionDTO> productComposition) {
        this.productToDTOConverter = productToDTOConverter;
        this.productComposition = productComposition;
    }

    @Override
    public RecipeDTO convert(RecipeEntity recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();

        AuxFieldsDTO auxFieldsDTO = new AuxFieldsDTO();
        recipeDTO.setUuid(auxFieldsDTO.getUuid());
        recipeDTO.setDt_create(auxFieldsDTO.getDt_create());
        recipeDTO.setDt_update(auxFieldsDTO.getDt_update());
        recipeDTO.setTitle(recipe.getTitle());

        List<IngredientEntity> productList = recipe.getComposition();
        List<CompositionDTO> productComposition = calculateRecipeComposition(productList);
        recipeDTO.setComposition(productComposition);

        int weight = productComposition
                .stream()
                .mapToInt(CompositionDTO::getWeight)
                .sum();
        int calories = productComposition
                .stream()
                .mapToInt(CompositionDTO::getCalories)
                .sum();
        double proteins =productComposition
                .stream()
                .mapToDouble(CompositionDTO::getProteins)
                .sum();
        double fats = productComposition
                .stream()
                .mapToDouble(CompositionDTO::getFats)
                .sum();
        double carbohydrates = productComposition
                .stream()
                .mapToDouble(CompositionDTO::getCarbohydrates)
                .sum();

        recipeDTO.setWeight(weight);
        recipeDTO.setCalories(calories);
        recipeDTO.setProteins(proteins);
        recipeDTO.setFats(fats);
        recipeDTO.setCarbohydrates(carbohydrates);

        return  recipeDTO;
    }

    private List<CompositionDTO> calculateRecipeComposition(List<IngredientEntity> productList) {
        List<CompositionDTO> recipeComposition = new ArrayList<>();

        for (IngredientEntity product : productList){

                    CompositionDTO compositionDTO = new CompositionDTO();

                    ProductEntityToDtoConverter conv = new ProductEntityToDtoConverter();

                    ProductDTO productDTO = conv.convert(product.getProductEntity());
                    int weight = productDTO.getWeight();
                    double k = (double) weight / productDTO.getWeight();
                    int calories = (int) (productDTO.getCalories() * k);
                    double proteins = productDTO.getProteins() * k;
                    double fats = productDTO.getFats() * k;
                    double carbohydrates = productDTO.getCarbohydrates() * k;

                    compositionDTO.setProduct(productDTO);
                    compositionDTO.setWeight(weight);
                    compositionDTO.setCalories(calories);
                    compositionDTO.setProteins(proteins);
                    compositionDTO.setFats(fats);
                    compositionDTO.setCarbohydrates(carbohydrates);

                    recipeComposition.add(compositionDTO);
                }


        return recipeComposition;
    }


}
