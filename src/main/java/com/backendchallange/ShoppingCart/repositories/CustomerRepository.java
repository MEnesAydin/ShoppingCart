package com.backendchallange.ShoppingCart.repositories;

import com.backendchallange.ShoppingCart.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
}
