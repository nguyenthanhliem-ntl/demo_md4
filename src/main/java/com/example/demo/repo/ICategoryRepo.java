package com.example.demo.repo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends PagingAndSortingRepository<Category,Long> {
}
