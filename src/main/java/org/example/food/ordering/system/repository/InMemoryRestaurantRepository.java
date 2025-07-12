package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.Menu;
import org.example.food.ordering.system.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRestaurantRepository implements IRestaurantRepository {
    private final Map<String, Restaurant> restaurantMap;

    public InMemoryRestaurantRepository() {
        restaurantMap = new HashMap<>();
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantMap.putIfAbsent(restaurant.getId(), restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantMap.values());
    }

    @Override
    public void updateRestaurantMenu(String restaurantId, Menu menu) {
        Restaurant restaurant = restaurantMap.getOrDefault(restaurantId, null);
        if(restaurant != null) {
            restaurant.updateMenu(menu);
            saveRestaurant(restaurant);
        }
    }
}
