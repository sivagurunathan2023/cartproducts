package com.example.product.controller;

import com.example.product.entity.Order;
import com.example.product.entity.Product;
import com.example.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // POST /api/orders – Place a new order
    @PostMapping("/orders")
    public Order placeOrder(@RequestParam int userId, @RequestBody List<Product> cartItems) {
        return orderService.placeOrder(userId, cartItems);
    }

    // GET /api/orders/:userId – Get orders for a user
    @GetMapping("/orders/{userId}")
    public List<Order> getUserOrders(@PathVariable int userId) {
        return orderService.getUserOrders(userId);
    }

    // GET /api/admin/orders – Admin: get all orders
    @GetMapping("/admin/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
