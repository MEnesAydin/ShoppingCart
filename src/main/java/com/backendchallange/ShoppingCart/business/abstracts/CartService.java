package com.backendchallange.ShoppingCart.business.abstracts;

import com.backendchallange.ShoppingCart.business.dtos.Cart.GetCart;

import java.util.List;

public interface CartService {
    GetCart GetById(int id);
    void Update(int cartId,int productId,int quantity);
    void EmptyCart(int cartId);
    void AddProduct(int cartId,int productId,int quantity);
    public void RemoveProductFromCart(int cartId,int productId);
}
