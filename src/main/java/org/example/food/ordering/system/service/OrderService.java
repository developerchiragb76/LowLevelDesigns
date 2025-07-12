package org.example.food.ordering.system.service;

import org.example.food.ordering.system.model.*;
import org.example.food.ordering.system.repository.IOrderRepository;

import java.util.List;
import java.util.UUID;

public class OrderService {
    private final IOrderRepository orderRepository;
    private final UserService userService;

    public OrderService(IOrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public Order createOrder(String userId, Restaurant restaurant, List<OrderInputItem> orderInputItemList) {
        User user = userService.getUserById(userId);

        double totalAmount = restaurant.calculateTotalAmount(orderInputItemList);

        String orderId = UUID.randomUUID().toString();
        final Order order = new Order(user, orderInputItemList, totalAmount, restaurant, OrderStatus.ACCEPTED);
        order.setOrderId(orderId);
        orderRepository.saveOrder(order);
        return order;
    }

    public void updateOrderStatus(OrderStatus orderStatus, String orderId) {
        Order order = orderRepository.getOrder(orderId);
        order.setOrderStatus(orderStatus);
        orderRepository.saveOrder(order);
    }
}
