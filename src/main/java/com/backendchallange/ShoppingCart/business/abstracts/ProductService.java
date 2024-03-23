package com.backendchallange.ShoppingCart.business.abstracts;

import com.backendchallange.ShoppingCart.business.dtos.Product.CreateProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.GetProduct;
import com.backendchallange.ShoppingCart.business.dtos.Product.UpdateProduct;

public interface ProductService {
    void Add(CreateProduct createProduct);
    GetProduct GetById(int id);
    void Update(UpdateProduct updateProduct);

    void UpdateQuantity(int productId,int quantity);
    void Delete(int id);
}
