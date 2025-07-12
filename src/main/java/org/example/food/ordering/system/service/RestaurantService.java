package org.example.food.ordering.system.service;

import org.example.food.ordering.system.model.Restaurant;
import org.example.food.ordering.system.repository.IRestaurantRepository;

import java.util.List;

public class RestaurantService {
    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }
}
