package org.example.food.ordering.system.service;

import org.example.food.ordering.system.model.Order;
import org.example.food.ordering.system.model.OrderInputItem;
import org.example.food.ordering.system.model.Restaurant;
import org.example.food.ordering.system.model.SelectionCriteria;
import org.example.food.ordering.system.strategy.IRestaurantFilterStrategy;
import org.example.food.ordering.system.strategy.IRestaurantPickingStrategy;

import java.util.List;

public class FoodOrderingService {
    private final RestaurantService restaurantService;
    private final OrderService orderService;
    private final List<IRestaurantPickingStrategy> restaurantPickingStrategies;
    private final List<IRestaurantFilterStrategy> restaurantFilterStrategies;

    public FoodOrderingService(RestaurantService restaurantService, OrderService orderService, List<IRestaurantPickingStrategy> restaurantPickingStrategies, List<IRestaurantFilterStrategy> restaurantFilterStrategies) {
        this.restaurantService = restaurantService;
        this.orderService = orderService;
        this.restaurantPickingStrategies = restaurantPickingStrategies;
        this.restaurantFilterStrategies = restaurantFilterStrategies;
    }

    public Order placeOrder(final List<OrderInputItem> orderInputItemList, String userId, SelectionCriteria selectionCriteria) {
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();

        for(IRestaurantFilterStrategy restaurantFilterStrategy : restaurantFilterStrategies) {
            allRestaurants = restaurantFilterStrategy.filter(allRestaurants, orderInputItemList);
        }

        final IRestaurantPickingStrategy restaurantPickingStrategy = restaurantPickingStrategies.stream().filter(sr -> sr.doesSupport(selectionCriteria)).findAny().orElseThrow(RuntimeException::new);

        final Restaurant restaurant = restaurantPickingStrategy.pickRestaurant(orderInputItemList, allRestaurants);

        return orderService.createOrder(userId, restaurant, orderInputItemList);
    }
}
