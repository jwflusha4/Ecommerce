package com.shaw.ProductCatalog.dto;

import com.shaw.ProductCatalog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String title;
    private String description;
    private Category category;
    private double price;
    private String imageUrl;
}
