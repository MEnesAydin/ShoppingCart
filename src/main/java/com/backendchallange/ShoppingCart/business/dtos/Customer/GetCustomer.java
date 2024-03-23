package com.backendchallange.ShoppingCart.business.dtos.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomer {
    private int id;
    private String username;

}
