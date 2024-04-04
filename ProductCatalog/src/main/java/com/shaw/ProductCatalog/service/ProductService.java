package com.shaw.ProductCatalog.service;

import com.shaw.ProductCatalog.dto.ProductRequest;
import com.shaw.ProductCatalog.dto.ProductResponse;
import com.shaw.ProductCatalog.model.Category;
import com.shaw.ProductCatalog.model.Product;
import com.shaw.ProductCatalog.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest request) {
        Product product=Product.builder()
                .category(request.getCategory())
                .description(request.getDescription())
                .title(request.getTitle())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .build();
        productRepository.save(product);
        ProductResponse productResponse=ProductResponse.builder()
                .category(product.getCategory())
                .description(product.getDescription())
                .title(product.getTitle())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .createdAt(new Date())
                .build();
        return productResponse;
    }
    public List<Product> getProductId(List<String> ids){
        List<Product> product=productRepository.findAllById(ids);
        return product;
    }
    public List<Product> getProductByTitle(String title) {
        List<Product> product=productRepository.findByTitle(title);
        if(product!=null){
            return product;
        }
        throw new RuntimeException("Product not found");
    }

    public List<Product> getProductByCategory(Category category) {
        List<Product> product=productRepository.findByCategory(category);
        if(product!=null){
            return product;
        }
        throw new RuntimeException("Product not found");
    }

    public ResponseEntity<Product> updateProduct(String id, ProductRequest request) {
        Optional<Product> product=productRepository.findById(id);
        product.get().setCategory(request.getCategory());
        product.get().setTitle(request.getTitle());
        product.get().setDescription(request.getDescription());
        product.get().setPrice(request.getPrice());
        product.get().setImageUrl(request.getImageUrl());
        product.get().setLastModified(new Date());
        productRepository.save(product.get());
        if(product==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(product.get());
        }
        return ResponseEntity.ok(product.get());
    }
}
