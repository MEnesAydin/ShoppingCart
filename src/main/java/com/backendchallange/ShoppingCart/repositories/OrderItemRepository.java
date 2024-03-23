package com.backendchallange.ShoppingCart.repositories;

import com.backendchallange.ShoppingCart.entities.concretes.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
