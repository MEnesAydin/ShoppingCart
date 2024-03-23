package com.backendchallange.ShoppingCart.entities.concretes;

import com.backendchallange.ShoppingCart.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order extends BaseEntity {
    private LocalDate orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<OrderItem> orderItems;
}
