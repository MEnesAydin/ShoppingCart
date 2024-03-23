package com.backendchallange.ShoppingCart.entities.concretes;

import com.backendchallange.ShoppingCart.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {
    private String username;

    @OneToOne(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Order> orders;
}
