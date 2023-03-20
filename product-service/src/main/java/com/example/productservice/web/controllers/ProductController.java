package com.example.productservice.web.controllers;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.service.api.IProductService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    Converter<NewProductDTO, ProductEntity> toEntity;

    IProductService productService;

    public ProductController(Converter<NewProductDTO, ProductEntity> toEntity, IProductService productService) {
        this.toEntity = toEntity;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody NewProductDTO product) {
        ProductEntity productEntity = toEntity.convert(product);
        this.productService.create(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
    @GetMapping
    public PageDTO<ProductDTO> getUserPage(Pageable pageable) {
        return this.productService.getPage(pageable);
    }

    @PutMapping("/{uuid}/dt_update/{lastUpdated}")
    public ResponseEntity<String> updateUser(@PathVariable UUID uuid,
                                             @PathVariable Timestamp lst_updated,
                                             @RequestBody NewProductDTO product) {
        this.productService.updateProduct(uuid, lst_updated, product);
        return ResponseEntity.ok()
                .build();
    }

}
