package com.example.productservice.service;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.repo.IProductRepository;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.service.api.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


public class ProductService implements IProductService {

    private IProductRepository repository;

    private Converter<ProductEntity, ProductDTO> toDTOConverter;

    public ProductService(IProductRepository repository, Converter<ProductEntity, ProductDTO> toDTOConverter) {
        this.repository = repository;
        this.toDTOConverter = toDTOConverter;
    }

    @Override
    public void create(ProductEntity product) {
        repository.save(product);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageble) {
        Page<ProductEntity> page = repository.findAll(pageble);
        return page.map(toDTOConverter::convert);
    }

    @Override
    public ProductEntity getById(UUID uuid) {
        return this.repository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("uuid"));
    }

    @Override
    public void updateProduct(UUID uuid, Timestamp dtUpdate, NewProductDTO product) {
            ProductEntity productUpdate = repository.findById(uuid)
                    .orElseThrow(() -> new EntityNotFoundException("uuid"));

        if (Timestamp.valueOf(productUpdate.getDt_update()).equals(dtUpdate)) {
            updatingProduct(product, productUpdate);

            }
        }


    private void updatingProduct(NewProductDTO product, ProductEntity productUpdate) {
        productUpdate.setTitle(product.getTitle());
        productUpdate.setWeight(product.getWeight());
        productUpdate.setCalories(product.getCalories());
        productUpdate.setProteins(product.getProteins());
        productUpdate.setFats(product.getFats());
        productUpdate.setCarbohydrates(product.getCarbohydrates());
        repository.save(productUpdate);
    }

}
