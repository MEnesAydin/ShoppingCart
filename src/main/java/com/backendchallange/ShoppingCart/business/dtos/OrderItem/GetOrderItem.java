package com.backendchallange.ShoppingCart.business.dtos.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderItem {
    private int id;
    private String productName;
    private int quantity;
    private double price;

}
