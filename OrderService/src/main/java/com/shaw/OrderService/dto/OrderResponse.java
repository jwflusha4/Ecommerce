package com.shaw.OrderService.dto;

import com.shaw.OrderService.model.CartDTO;
import com.shaw.OrderService.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private String cartId;
    private double totalAmount;
    private OrderStatus status;
    private CartDTO cartDTO;
}
