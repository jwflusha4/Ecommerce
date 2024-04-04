package com.shaw.OrderService.controller;

import com.shaw.OrderService.dto.OrderRequest;
import com.shaw.OrderService.dto.OrderResponse;
import com.shaw.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.PROCESSING)
    public OrderResponse addOrder(@RequestBody OrderRequest request){
        return orderService.addOrder(request);
    }
}
