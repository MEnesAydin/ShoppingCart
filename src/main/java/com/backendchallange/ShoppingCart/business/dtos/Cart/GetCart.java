package com.backendchallange.ShoppingCart.business.dtos.Cart;

import com.backendchallange.ShoppingCart.business.dtos.CartItem.CartItemDTO;
import com.backendchallange.ShoppingCart.business.dtos.Product.GetProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCart {
    private int id;
    private Double totalPrice;
    private List<CartItemDTO> products;
}
