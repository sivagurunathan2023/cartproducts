package com.example.product.controller;

import com.example.product.entity.Order;
import com.example.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

 
    @PostMapping("/orders")
    public Order placeOrder(@RequestParam int userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/orders/{userId}")
    public List<Order> getUserOrders(@PathVariable int userId) {
        return orderService.getUserOrders(userId);
    }

    
    @GetMapping("/admin/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
