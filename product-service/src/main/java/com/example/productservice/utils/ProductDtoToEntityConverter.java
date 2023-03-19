package com.example.productservice.utils;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.NewProductDTO;
import org.springframework.core.convert.converter.Converter;

public class ProductDtoToEntityConverter implements Converter<NewProductDTO, ProductEntity> {
    @Override
    public ProductEntity convert(NewProductDTO source) {
        return null;
    }
}
