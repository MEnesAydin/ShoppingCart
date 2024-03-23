package com.backendchallange.ShoppingCart.entities.concretes;

import com.backendchallange.ShoppingCart.entities.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem extends BaseEntity {
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;




}
