package com.example.productservice.service.api;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.UUID;


public interface IProductService {
    void create(ProductEntity product);

    PageDTO<ProductDTO> getPage(Pageable pageable);

    ProductEntity getById(UUID uuid);
    void updateProduct(UUID uuid, Timestamp dtUpdate, NewProductDTO product);
}
