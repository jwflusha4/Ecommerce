package com.shaw.CartService.dto;

import com.shaw.CartService.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    private List<CartItemRequest> cartItems;
}
