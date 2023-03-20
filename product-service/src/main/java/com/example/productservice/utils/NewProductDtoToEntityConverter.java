package com.example.productservice.utils;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.AuxFieldsDTO;
import org.springframework.core.convert.converter.Converter;

public class NewProductDtoToEntityConverter implements Converter<NewProductDTO, ProductEntity> {

    @Override
    public ProductEntity convert(NewProductDTO source) {
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
