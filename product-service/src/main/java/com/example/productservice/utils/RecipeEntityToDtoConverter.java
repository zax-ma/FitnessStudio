package com.example.productservice.utils;

import com.example.productservice.dao.entity.IngredientEntity;
import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.entity.RecipeEntity;
import com.example.productservice.dto.AuxFieldsDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.dto.recipe.CompositionDTO;
import com.example.productservice.dto.recipe.RecipeDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RecipeEntityToDtoConverter implements Converter<RecipeEntity, RecipeDTO> {
    private Converter<ProductEntity, ProductDTO> productToDTOConverter;
    private List<CompositionDTO> productComposition;

    public RecipeEntityToDtoConverter() {
    }

    @Override
    public RecipeDTO convert(RecipeEntity recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        AuxFieldsDTO auxFieldsDTO = new AuxFieldsDTO(recipe.getUuid(),
                recipe.getDt_create(), recipe.getDt_update());
        recipeDTO.setUuid(auxFieldsDTO.getUuid());
        recipeDTO.setDt_create(auxFieldsDTO.getDt_create());
        recipeDTO.setDt_update(auxFieldsDTO.getDt_update());
        recipeDTO.setTitle(recipe.getTitle());

        List<IngredientEntity> productList = recipe.getComposition();
        List<CompositionDTO> productComposition = calculateRecipeComposition(productList);
        recipeDTO.setComposition(productComposition);

        int weight = (int) round(productComposition
                .stream()
                .mapToInt(CompositionDTO::getWeight)
                .sum(), 2);
        int calories = (int) round(productComposition
                .stream()
                .mapToInt(CompositionDTO::getCalories)
                .sum(), 2);
        double proteins = round(productComposition
                .stream()
                .mapToDouble(CompositionDTO::getProteins)
                .sum(), 2);
        double fats = round(productComposition
                .stream()
                .mapToDouble(CompositionDTO::getFats)
                .sum(), 2);
        double carbohydrates = round(productComposition
                .stream()
                .mapToDouble(CompositionDTO::getCarbohydrates)
                .sum(), 2);

        recipeDTO.setWeight(weight);
        recipeDTO.setCalories(calories);
        recipeDTO.setProteins(round(proteins, 1));
        recipeDTO.setFats(round(fats, 1));
        recipeDTO.setCarbohydrates(round(carbohydrates, 1));

        return  recipeDTO;
    }

    private List<CompositionDTO> calculateRecipeComposition(List<IngredientEntity> productList) {
        List<CompositionDTO> recipeComposition = productList.stream()
                .map(product -> {
                    CompositionDTO compositionDTO = new CompositionDTO();

                    ProductDTO productDTO = productToDTOConverter.convert(product.getProductEntity());
                    int actualWeight = product.getWeight();
                    int standardWeight = productDTO.getWeight();
                    double ratio = 1.0 * actualWeight / standardWeight;
                    int calories = (int) (ratio * productDTO.getCalories());
                    double proteins = round(ratio * productDTO.getProteins(),1);
                    double fats = round(ratio * productDTO.getFats(), 1);
                    double carbohydrates = round(ratio * productDTO.getCarbohydrates(), 1);

                    compositionDTO.setProduct(productDTO);
                    compositionDTO.setWeight(actualWeight);
                    compositionDTO.setCalories(calories);
                    compositionDTO.setProteins(proteins);
                    compositionDTO.setFats(fats);
                    compositionDTO.setCarbohydrates(carbohydrates);

                    return compositionDTO;
                })
                .toList();

        return recipeComposition;
    }

    private double round(double number, int places) {
        if (places < 1 || places > 1000) {
            throw new IllegalArgumentException("Can't round to '"
                    + places + "' decimal places!");
        }
        double multiplier = 10.0 * places;
        return Math.round(number * multiplier) / multiplier;
    }
}
