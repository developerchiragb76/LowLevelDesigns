package org.example.food.ordering.system.strategy;

import org.example.food.ordering.system.model.OrderInputItem;
import org.example.food.ordering.system.model.Restaurant;

import java.util.List;

public class ItemQuantityValidationFilteringStrategy implements IRestaurantFilterStrategy {
    @Override
    public List<Restaurant> filter(List<Restaurant> allRestaurants, List<OrderInputItem> orderInputItemList) {
        return List.of();
    }
}
