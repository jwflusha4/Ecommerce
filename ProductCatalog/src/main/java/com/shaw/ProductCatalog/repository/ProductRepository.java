package com.shaw.ProductCatalog.repository;

import com.shaw.ProductCatalog.model.Category;
import com.shaw.ProductCatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByTitle(String title);

    List<Product> findByCategory(Category category);

}
