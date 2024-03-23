package com.backendchallange.ShoppingCart.controllers;

import com.backendchallange.ShoppingCart.business.abstracts.OrderService;
import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrder;
import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrders;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping("/PlaceOrder")
    public ResponseEntity<String> PlaceOrder(int customerId){
        orderService.PlaceOrder(customerId);
        return ResponseEntity.ok("Sipariş başarıyla oluşturuldu");
    }

    @GetMapping("/GetOrderForCode")
    public ResponseEntity<GetOrder> getOrderForCode(int orderId) {
        GetOrder getOrder = orderService.GetOrderForCode(orderId);
        return ResponseEntity.ok(getOrder);
    }

    @GetMapping("/GetAllOrdersForCustomer")
    public ResponseEntity<List<GetOrders>> GetAllOrdersForCustomer(int customerId){
        List<GetOrders> getOrders = orderService.GetAllOrdersForCustomer(customerId);
        return ResponseEntity.ok(getOrders);
    }
}
