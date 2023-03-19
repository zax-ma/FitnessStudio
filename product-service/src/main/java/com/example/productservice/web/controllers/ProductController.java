package com.example.productservice.web.controllers;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.core.convert.converter.Converter;

public class ProductController {
    private Converter<NewProductDTO, ProductEntity> toEntityConverter;

}
