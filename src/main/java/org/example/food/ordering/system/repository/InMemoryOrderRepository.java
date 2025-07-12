package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryOrderRepository implements IOrderRepository {
    private final Map<String, Order> orderMap;

    public InMemoryOrderRepository() {
        orderMap = new HashMap<>();
    }

    @Override
    public void saveOrder(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderMap.getOrDefault(orderId, null);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    @Override
    public List<Order> getAllOrdersForARestaurant(String restaurantId) {
        return orderMap.values().stream().filter(order -> order.getRestaurant().getId().equals(restaurantId)).collect(Collectors.toList());
    }
}
