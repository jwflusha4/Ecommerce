package com.shaw.CartService.controller;

import com.shaw.CartService.dto.CartDTO;
import com.shaw.CartService.dto.CartRequest;
import com.shaw.CartService.dto.CartResponse;
import com.shaw.CartService.model.Cart;
import com.shaw.CartService.service.CartService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse addToCart(@RequestBody CartRequest request){
        return cartService.addToCart(request);
    }

    @DeleteMapping("/remove/{id}/{cid}")
    @ResponseStatus(HttpStatus.FOUND)
    public String removeFromCart(@PathVariable("id") String id,@PathVariable("cid") String pid){
        return cartService.removeCartItem(new ObjectId(id),new ObjectId(pid));
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public CartDTO getCartFromId(@PathVariable("id") String id){
        CartDTO cart=cartService.getCardFromId(new ObjectId((id)));
        return cart;
    }
}
