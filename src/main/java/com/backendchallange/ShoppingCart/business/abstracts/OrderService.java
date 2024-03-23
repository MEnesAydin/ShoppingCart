package com.backendchallange.ShoppingCart.business.abstracts;

import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrder;
import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrders;

import java.util.List;

public interface OrderService {
    void PlaceOrder(int CustomerId);
    GetOrder GetOrderForCode(int id);
    List<GetOrders> GetAllOrdersForCustomer(int customerId);
}
