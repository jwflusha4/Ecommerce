package com.shaw.OrderService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    @JsonProperty("id") // Specify the JSON field name
    private String id;
    @JsonProperty("cartItems") // Specify the JSON field name
    private List<CartItemDTO> cartItems;
}
