package com.backendchallange.ShoppingCart.business.dtos.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private int productId;
    private String productName;
    private int quantity;
    private double price;
}
