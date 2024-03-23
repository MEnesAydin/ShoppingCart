package com.backendchallange.ShoppingCart.business.dtos.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderItems {
    private String productName;
    private int quantity;
}
