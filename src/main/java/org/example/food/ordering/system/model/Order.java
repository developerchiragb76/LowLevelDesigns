package org.example.food.ordering.system.model;

import java.util.List;

public class Order {
    private String orderId;
    private final User orderedBy;
    private final List<OrderInputItem> orderInputItems;
    private final double orderAmount;
    private final Restaurant restaurant;
    private OrderStatus orderStatus;

    public Order(User orderedBy, List<OrderInputItem> orderInputItems, double orderAmount, Restaurant restaurant, OrderStatus orderStatus) {
        this.orderedBy = orderedBy;
        this.orderInputItems = orderInputItems;
        this.orderAmount = orderAmount;
        this.restaurant = restaurant;
        this.orderStatus = orderStatus;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getOrderedBy() {
        return orderedBy;
    }

    public List<OrderInputItem> getOrderInputItems() {
        return orderInputItems;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
