package com.backendchallange.ShoppingCart.business.concretes;

import com.backendchallange.ShoppingCart.business.abstracts.CartService;
import com.backendchallange.ShoppingCart.business.abstracts.OrderService;
import com.backendchallange.ShoppingCart.business.abstracts.ProductService;
import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrder;
import com.backendchallange.ShoppingCart.business.dtos.Order.GetOrders;
import com.backendchallange.ShoppingCart.business.dtos.OrderItem.GetOrderItem;
import com.backendchallange.ShoppingCart.entities.concretes.*;
import com.backendchallange.ShoppingCart.repositories.CartRepository;
import com.backendchallange.ShoppingCart.repositories.CustomerRepository;
import com.backendchallange.ShoppingCart.repositories.OrderItemRepository;
import com.backendchallange.ShoppingCart.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private ProductService productService;
    private CartService cartService;


    @Transactional
    @Override
    public void PlaceOrder(int customerId) {
        Customer customer = customerRepository.findById(customerId);
        Cart cart = cartRepository.findByCustomerId(customerId);
        Order order = new Order();

        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(cart.getTotalprice());

        order = orderRepository.save(order);

        List<CartItem> cartItems = cart.getCartItems();
        List<OrderItem> orderItems = new ArrayList<>();

        for(CartItem cartItem:cartItems){
            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setName(cartItem.getProduct().getName());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setQuantity(cartItem.getQuantity());

            orderItems.add(orderItem);

        }

        orderItemRepository.saveAll(orderItems);
        cartService.EmptyCart(cart.getId());


        for (CartItem item : cart.getCartItems()) {
            int quantity = item.getQuantity();
            Product product = item.getProduct();
            productService.UpdateQuantity(product.getId(), product.getQuantity() - quantity);
        }

    }

    @Override
    public GetOrder GetOrderForCode(int id) {
        Order order = orderRepository.findById(id);

        GetOrder getOrder = new GetOrder();
        getOrder.setId(order.getId());
        getOrder.setOrderDate(order.getOrderDate());
        getOrder.setTotalAmount(order.getTotalAmount());

        List<GetOrderItem> getOrderItems = new ArrayList<>();
        for(OrderItem orderItem : order.getOrderItems()){
            GetOrderItem getOrderItem = new GetOrderItem();

            getOrderItem.setId(orderItem.getId());
            getOrderItem.setProductName(orderItem.getName());
            getOrderItem.setPrice(orderItem.getPrice());
            getOrderItem.setQuantity(orderItem.getQuantity());

            getOrderItems.add(getOrderItem);
        }
        getOrder.setOrderItems(getOrderItems);
        return getOrder;
    }

    @Override
    public List<GetOrders> GetAllOrdersForCustomer(int customerId) {
        List<Order> orders = orderRepository.findAllByCustomerId(customerId);
        List<GetOrders> getOrders = new ArrayList<>();

        for(Order order:orders){
            GetOrders getOrder = new GetOrders();

            getOrder.setId(order.getId());
            getOrder.setOrderDate(order.getOrderDate());
            getOrder.setTotalAmount(order.getTotalAmount());

            getOrders.add(getOrder);
        }
        return getOrders;
    }


}
