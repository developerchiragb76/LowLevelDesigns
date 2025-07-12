package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.Order;

import java.util.List;

public interface IOrderRepository {
    void saveOrder(Order order);

    Order getOrder(String orderId);

    List<Order> getAllOrders();

    List<Order> getAllOrdersForARestaurant(String restaurantId);
}
