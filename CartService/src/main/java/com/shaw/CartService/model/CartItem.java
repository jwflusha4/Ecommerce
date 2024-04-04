package com.shaw.CartService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItem {
    @Id
    @JsonProperty("id")
    private ObjectId id;
    @JsonProperty("pId")
    private String pId;
    @JsonProperty("quantity")
    private Integer quantity;
}
