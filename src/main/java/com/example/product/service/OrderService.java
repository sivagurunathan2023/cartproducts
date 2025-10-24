package com.example.product.service;

import com.example.product.entity.Order;
import com.example.product.entity.Product;
import com.example.product.repository.OrderRepository;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order placeOrder(int userId) {
    
        List<Product> cartItems = productRepository.findAll()
                .stream()
                .filter(p -> p.getUserId() == userId)
                .toList();

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty for userId: " + userId);
        }

     
        double total = cartItems.stream()
                .mapToDouble(item -> item.getProductPrice() * item.getProductQuantity())
                .sum();

     
        Order order = new Order(userId, total, LocalDateTime.now(), cartItems);
        orderRepository.save(order);

      
        productRepository.deleteAll(cartItems);

        return order;
    }

    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
