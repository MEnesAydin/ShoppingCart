package com.backendchallange.ShoppingCart.business.dtos.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrders {
    private int id;
    private LocalDate orderDate;
    private double totalAmount;
}
