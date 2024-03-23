package com.backendchallange.ShoppingCart.repositories;

import com.backendchallange.ShoppingCart.business.dtos.CartItem.CartItemDTO;
import com.backendchallange.ShoppingCart.entities.concretes.Cart;
import com.backendchallange.ShoppingCart.entities.concretes.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
    Cart findByCustomerId(int id);
    boolean existsCartItemById(int id);
}
