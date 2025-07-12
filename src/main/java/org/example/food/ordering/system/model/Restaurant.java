package org.example.food.ordering.system.model;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private Menu menu;
    private Integer maxOrderProcessingCapacity;

    public double calculateTotalAmount(List<OrderInputItem> orderInputItemList) {
        return 0.0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public Integer getMaxOrderProcessingCapacity() {
        return maxOrderProcessingCapacity;
    }

    public void updateMenu(Menu menu) {
        this.menu = menu;
    }
}
