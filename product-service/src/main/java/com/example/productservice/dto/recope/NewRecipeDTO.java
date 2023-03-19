package com.example.productservice.dto.recope;

import com.example.productservice.dto.product.ProductDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class NewRecipeDTO {
    @NotBlank
    @NotNull
    private String title;
    @Size(min = 1)
    @NotNull
    private List<IngredientDTO> composition;


    public NewRecipeDTO(String title,
                           List<IngredientDTO> composition) {
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
