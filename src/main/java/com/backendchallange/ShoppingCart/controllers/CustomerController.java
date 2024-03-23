package com.backendchallange.ShoppingCart.controllers;

import com.backendchallange.ShoppingCart.business.abstracts.CustomerService;
import com.backendchallange.ShoppingCart.business.dtos.Customer.AddCustomer;
import com.backendchallange.ShoppingCart.business.dtos.Customer.GetCustomer;
import com.backendchallange.ShoppingCart.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public GetCustomer Add(@RequestBody AddCustomer addCustomer){
        return customerService.Add(addCustomer);
    }
}
