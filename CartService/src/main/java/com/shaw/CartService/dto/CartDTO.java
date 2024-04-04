package com.shaw.CartService.dto;

import com.shaw.CartService.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    private String id;
    private List<CartItemDTO> cartItems;
}
