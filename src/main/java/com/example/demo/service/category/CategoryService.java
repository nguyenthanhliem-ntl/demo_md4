package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryService;


    @Override
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryService.save(category);
    }

    @Override
    public void remote(Long id) {
        categoryService.deleteById(id);
    }
}
