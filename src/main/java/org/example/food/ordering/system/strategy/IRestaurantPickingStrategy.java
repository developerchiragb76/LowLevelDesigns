package org.example.food.ordering.system.strategy;

import org.example.food.ordering.system.model.OrderInputItem;
import org.example.food.ordering.system.model.Restaurant;
import org.example.food.ordering.system.model.SelectionCriteria;

import java.util.List;

public interface IRestaurantPickingStrategy {
    boolean doesSupport(SelectionCriteria selectionCriteria);
    Restaurant pickRestaurant(List<OrderInputItem> orderInputItemList, List<Restaurant> filteredRestaurants);
}
