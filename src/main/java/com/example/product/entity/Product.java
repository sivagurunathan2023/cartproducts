package com.example.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Column(name = "product_rating")
    private double productRating;

    public Product() {}

    public Product(int cartId, int userId, String productName, double productPrice, int productQuantity, double productRating) {
        this.cartId = cartId;
        this.userId = userId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productRating = productRating;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }
}
