package com.backendchallange.ShoppingCart.business.dtos.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProduct {
    private String name;
    private int quantity;
    private double price;
}
