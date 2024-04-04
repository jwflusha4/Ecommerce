package com.shaw.ProductCatalog.dto;

import com.shaw.ProductCatalog.model.Category;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Date createdAt=new Date();
    @Builder.Default
    private Date lastModified=new Date();
    private String title;
    private String description;
    private Category category;
    private double price;
    private String imageUrl;
}
