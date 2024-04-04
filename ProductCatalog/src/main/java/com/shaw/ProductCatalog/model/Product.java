package com.shaw.ProductCatalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseModel {
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;
    private String imageUrl;

}
