package com.example.productservice.service;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.repo.IProductRepository;
import com.example.productservice.dto.PageDTO;
import com.example.productservice.dto.product.NewProductDTO;
import com.example.productservice.dto.product.ProductDTO;
import com.example.productservice.service.api.IProductService;
import com.example.productservice.utils.exceptions.ProductExistException;
import com.example.productservice.utils.exceptions.ProductNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    private final IProductRepository repository;

    private final Converter<ProductEntity, ProductDTO> toDtoConverter;


    public ProductService(IProductRepository repository,
                          Converter<ProductEntity, ProductDTO> toDtoConverter) {
        this.repository = repository;
        this.toDtoConverter = toDtoConverter;
    }



    @Override
    public void create(ProductEntity product) {
        if(product.getTitle().equals(this.repository.findByTitle(product.getTitle())) ){
            throw new ProductExistException("Product is already added");
        }
        this.repository.save(product);
    }

    @Override
    public PageDTO<ProductDTO> getPage(Pageable pageable) {
        Page<ProductEntity> productEntityPage = this.repository.findAll(pageable);
        List<ProductDTO> content = new ArrayList<>();

        for (ProductEntity productEntity : this.repository.findAll()){
            content.add(toDtoConverter.convert(productEntity));
        }
        return new PageDTO<>(
                productEntityPage.getNumber(),
                productEntityPage.getSize(),
                productEntityPage.getTotalPages(),
                productEntityPage.getTotalElements(),
                productEntityPage.isFirst(),
                productEntityPage.getNumberOfElements(),
                productEntityPage.isLast(),
                content);
    }


    @Override
    public ProductEntity getById(UUID uuid) {

        return this.repository.findById(uuid)
                .orElseThrow(() -> new ProductNotFoundException("Product with uuid " + uuid + " was not found"));
    }
    @Override
    public void updateProduct(UUID id, Timestamp dt_update, NewProductDTO product) {
            ProductEntity productUpdate = this.repository.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product with uuid " + id + " was not found"));

        if (Timestamp.valueOf(productUpdate.getDt_update()).equals(dt_update)) {
            updatingProduct(product, productUpdate);

            }
        }


    private void updatingProduct(NewProductDTO product, ProductEntity productUpdate) {
        productUpdate.setTitle(product.getTitle());
        productUpdate.setDt_update(LocalDateTime.now());
        productUpdate.setWeight(product.getWeight());
        productUpdate.setCalories(product.getCalories());
        productUpdate.setProteins(product.getProteins());
        productUpdate.setFats(product.getFats());
        productUpdate.setCarbohydrates(product.getCarbohydrates());
        this.repository.save(productUpdate);
    }

}
