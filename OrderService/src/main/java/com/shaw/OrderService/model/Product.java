package com.shaw.OrderService.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;
    private String imageUrl;
}
