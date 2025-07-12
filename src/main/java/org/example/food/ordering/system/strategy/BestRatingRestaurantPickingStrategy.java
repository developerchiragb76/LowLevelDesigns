package org.example.food.ordering.system.strategy;

import org.example.food.ordering.system.model.OrderInputItem;
import org.example.food.ordering.system.model.Restaurant;
import org.example.food.ordering.system.model.SelectionCriteria;

import java.util.List;

public class BestRatingRestaurantPickingStrategy implements IRestaurantPickingStrategy {
    @Override
    public boolean doesSupport(SelectionCriteria selectionCriteria) {
        return SelectionCriteria.BEST_RATING.equals(selectionCriteria);
    }

    @Override
    public Restaurant pickRestaurant(List<OrderInputItem> orderInputItemList, List<Restaurant> filteredRestaurants) {
        return null;
    }
}
