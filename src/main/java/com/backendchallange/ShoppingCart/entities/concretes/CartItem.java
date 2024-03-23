package com.backendchallange.ShoppingCart.entities.concretes;

import com.backendchallange.ShoppingCart.entities.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem extends BaseEntity {
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
