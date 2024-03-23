package com.backendchallange.ShoppingCart.business.dtos.Order;

import com.backendchallange.ShoppingCart.business.dtos.OrderItem.GetOrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrder {
    private int id;
    private LocalDate orderDate;
    private double totalAmount;

    private List<GetOrderItem> orderItems;
}
