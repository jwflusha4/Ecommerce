package com.shaw.CartService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemDTO {
    private String id;
    private String pId;
    private Integer quantity;

}
