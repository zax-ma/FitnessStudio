package com.example.productservice.utils;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.core.convert.converter.Converter;

public class ProductDtoToEntityConverter implements Converter<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity convert(ProductDTO source) {
        return new ProductEntity(
                source.getUuid(),
                source.getDt_create(),
                source.getDt_update(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());
    }
}
