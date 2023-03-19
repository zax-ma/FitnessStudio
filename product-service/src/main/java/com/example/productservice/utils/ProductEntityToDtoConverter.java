package com.example.productservice.utils;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.core.convert.converter.Converter;

public class ProductEntityToDtoConverter implements Converter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity source) {
        return null;
    }
}
