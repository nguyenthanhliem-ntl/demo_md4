package com.example.demo.service.product;

import com.example.demo.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void remote(Long id);

}
