package com.shaw.CartService.repository;

import com.shaw.CartService.model.CartItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem, ObjectId> {
}
