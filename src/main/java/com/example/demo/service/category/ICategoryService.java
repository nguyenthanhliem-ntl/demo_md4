package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.model.Product;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    void remote(Long id);

}
