package com.shaw.CartService.service;

import com.shaw.CartService.dto.*;
import com.shaw.CartService.model.Cart;
import com.shaw.CartService.model.CartItem;
import com.shaw.CartService.repository.CartItemRepository;
import com.shaw.CartService.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    public CartResponse addToCart(CartRequest request) {
        Cart cart = new Cart();
        List<CartItem> cartItems = new ArrayList<>();
        System.out.println(request);
        // Iterate through each cart item in the request
        for (CartItemRequest temp : request.getCartItems()) {
            // Create a new cart item
            CartItem cartItem = new CartItem();
            cartItem.setPId(temp.getPid());
            cartItem.setQuantity(temp.getQuantity());
            cartItemRepository.save(cartItem);
            // Add the cart item to the list
            cartItems.add(cartItem);
        }

        // Save all the cart items to the database
        //List<CartItem> savedCartItems = cartItemRepository.saveAll(cartItems);
        for(CartItem it:cartItems){
            System.out.println(it);
        }
        // Set the list of saved cart items to the cart object
        cart.setCartItems(cartItems);

        // Save the cart to the database
        cartRepository.save(cart);

        // Prepare the response
        CartResponse cartResponse = CartResponse.builder()
                .response("Cart Added")
                .build();

        return cartResponse;
    }

    public String removeCartItem(ObjectId pid, ObjectId itemId) {
        // Retrieve the Cart from the CartRepository
        Cart cart = cartRepository.findById(itemId).orElse(null);
        if (cart == null) {
            return "Cart not found";
        }

        // Remove the CartItem from the Cart
        boolean removed = cart.getCartItems().removeIf(cartItem -> cartItem.getId().equals(pid));
        if (!removed) {
            return "Cart item not found";
        }

        // Delete the CartItem from the database
        cartItemRepository.deleteById(itemId);

        // Update the Cart in the database
        cartRepository.save(cart);

        return "Removed successfully";
    }

    public CartDTO getCardFromId(ObjectId id) {
        Cart cart=cartRepository.findById(id).get();
        List<CartItemDTO> cartItemDTOS=new ArrayList<>();
        for(CartItem it:cart.getCartItems()){
            CartItemDTO cartItemDTO=CartItemDTO.builder()
                    .id(it.getId().toString())
                    .pId(it.getPId())
                    .quantity(it.getQuantity())
                    .build();
            cartItemDTOS.add(cartItemDTO);
        }
        CartDTO cartDTO=CartDTO.builder()
                .id(cart.getId().toString())
                .cartItems(cartItemDTOS)
                .build();
        return cartDTO;

    }
}
