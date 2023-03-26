package com.example.productservice.utils;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.AuxFieldsDTO;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToEntityConverter implements Converter<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity convert(ProductDTO source) {
        AuxFieldsDTO auxFieldsDTO = new AuxFieldsDTO();
        return new ProductEntity(
                auxFieldsDTO.getUuid(),
                auxFieldsDTO.getDt_create(),
                auxFieldsDTO.getDt_update(),
                source.getTitle(),
                source.getWeight(),
                source.getCalories(),
                source.getProteins(),
                source.getFats(),
                source.getCarbohydrates());
    }
}
