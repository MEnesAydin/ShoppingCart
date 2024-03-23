package com.backendchallange.ShoppingCart.business.concretes;

import com.backendchallange.ShoppingCart.business.abstracts.CustomerService;
import com.backendchallange.ShoppingCart.business.dtos.Customer.AddCustomer;
import com.backendchallange.ShoppingCart.business.dtos.Customer.GetCustomer;
import com.backendchallange.ShoppingCart.entities.concretes.Cart;
import com.backendchallange.ShoppingCart.entities.concretes.Customer;
import com.backendchallange.ShoppingCart.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public GetCustomer Add(AddCustomer addCustomer) {
        Customer customer = new Customer();

        customer.setUsername(addCustomer.getUsername());
        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        customer = customerRepository.save(customer);
        GetCustomer getCustomer = new GetCustomer();
        getCustomer.setId(customer.getId());
        getCustomer.setUsername(customer.getUsername());
        return getCustomer;
    }
}
