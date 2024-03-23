package com.backendchallange.ShoppingCart.entities.concretes;

import com.backendchallange.ShoppingCart.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {
    private double totalprice = 0.0;

    @OneToMany(mappedBy = "cart", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
