package com.shaw.OrderService.service;

import com.shaw.OrderService.dto.OrderRequest;
import com.shaw.OrderService.dto.OrderResponse;
import com.shaw.OrderService.model.CartDTO;
import com.shaw.OrderService.model.Order;
import com.shaw.OrderService.model.OrderStatus;
import com.shaw.OrderService.model.Product;
import com.shaw.OrderService.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final WebClient webClient;
    private final OrderRepository orderRepository;
    public String func() {
        String str=webClient.get().uri("http://localhost:8085/api/product/temp")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return str;
    }
    @Transactional
    public OrderResponse addOrder(OrderRequest request) {
        CartDTO cartDTO =fun(request.getCartId());
        System.out.println(cartDTO);
        double amount=0;
        List<String> ids= cartDTO.getCartItems().stream().map(temp->temp.getPId()).toList();
        List<Integer> quanList=cartDTO.getCartItems().stream().map(temp->temp.getQuantity()).toList();

        List<Product> products=webClient.get()
                .uri("http://localhost:8085/api/product/get/id",
                        uriBuilder -> uriBuilder.queryParam("id",ids).build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Product>>() {})
                .block();

        for(int i=0;i<products.size();i++){
            amount+=(products.get(i).getPrice()* quanList.get(i).doubleValue());
            System.out.println(products.get(i));
        }
        Order order=Order.builder()
                .cartId(cartDTO.getId())
                .status(OrderStatus.INITIATED)
                .totalAmount(amount)
                .build();
        orderRepository.save(order);
        OrderResponse orderResponse=OrderResponse.builder()
                .cartDTO(cartDTO)
                .cartId(order.getCartId())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .id(order.getId())
                .build();
        System.out.println(orderResponse);
        return orderResponse;
    }
    public synchronized CartDTO fun(String str){
        CartDTO cartDTO =webClient.get().uri("http://localhost:8080/api/cart/get/{id}", str)
                .retrieve()
                .bodyToMono(CartDTO.class)
                .block();
        return cartDTO;
    }
}
