package com.example.productservice.dao.repo;


import com.example.productservice.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository extends JpaRepository<ProductEntity, UUID> {
    ProductEntity findByTitle(String title);

}
