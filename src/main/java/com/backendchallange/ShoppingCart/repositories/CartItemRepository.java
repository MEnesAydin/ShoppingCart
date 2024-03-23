package com.backendchallange.ShoppingCart.repositories;

import com.backendchallange.ShoppingCart.entities.concretes.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    CartItem findCartItemByProductIdAndCartId(int cartId, int productId);
    List<CartItem> findCartItemsByCartId(int id);
    void deleteAllByCartId(int id);
}
