package com.backendchallange.ShoppingCart.business.abstracts;

import com.backendchallange.ShoppingCart.business.dtos.Customer.AddCustomer;
import com.backendchallange.ShoppingCart.business.dtos.Customer.GetCustomer;
import com.backendchallange.ShoppingCart.entities.concretes.Customer;

public interface CustomerService {
    GetCustomer Add(AddCustomer addCustomer);
}
