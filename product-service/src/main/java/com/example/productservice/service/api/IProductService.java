package com.example.productservice.service.api;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;


public interface IProductService {
    void create(ProductEntity product);
    Page<ProductDTO> getPage(Pageable pageble);
    ProductEntity getById(UUID uuid);
    void updateProduct(UUID uuid, Timestamp dtUpdate, NewProductDTO product);
}
