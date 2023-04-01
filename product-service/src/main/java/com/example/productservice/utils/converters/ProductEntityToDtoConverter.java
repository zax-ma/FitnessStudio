package com.example.productservice.utils.converters;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToDtoConverter implements Converter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity source) {
        return new ProductDTO(
                source.getUuid(),
                source.getDt_create(),
                source.getDt_update(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates()
        );
    }
}
