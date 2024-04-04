package com.shaw.ProductCatalog.controller;

import com.shaw.ProductCatalog.dto.ProductRequest;
import com.shaw.ProductCatalog.dto.ProductResponse;
import com.shaw.ProductCatalog.model.Category;
import com.shaw.ProductCatalog.model.Product;
import com.shaw.ProductCatalog.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> getByTitle(@RequestParam("title") String title){
        return productService.getProductByTitle(title);
    }
    @GetMapping("/get/{category}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> getByCategory(@PathVariable Category category){
        return productService.getProductByCategory(category);
    }

    @PutMapping("/change/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody ProductRequest request){
        return productService.updateProduct(id,request);
    }

    @GetMapping("/temp")
    public String temp(){
        return "Hello World!!!!!!!!!!!";
    }

    @GetMapping("/get/id")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> getById(@RequestParam List<String> id){
        return productService.getProductId(id);
    }
}
