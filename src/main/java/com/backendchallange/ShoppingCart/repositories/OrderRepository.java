package com.backendchallange.ShoppingCart.repositories;

import com.backendchallange.ShoppingCart.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findById(int id);
    List<Order> findAllByCustomerId(int id);
}
