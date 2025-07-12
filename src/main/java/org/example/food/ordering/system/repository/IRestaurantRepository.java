package org.example.food.ordering.system.repository;

import org.example.food.ordering.system.model.Menu;
import org.example.food.ordering.system.model.Restaurant;

import java.util.List;

public interface IRestaurantRepository {
    void saveRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    void updateRestaurantMenu(String restaurantId, Menu menu);
}
