package org.example.coffee.machine.model;

import java.util.List;

public class Beverage {
    private final List<Ingredient> requiredIngredients;
    private final BeverageType beverageType;

    public Beverage(List<Ingredient> requiredIngredients, BeverageType beverageType) {
        this.requiredIngredients = requiredIngredients;
        this.beverageType = beverageType;
    }

    public List<Ingredient> getRequiredIngredients() {
        return requiredIngredients;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    // Suggestion: Add toString() overrides for easier debugging/logging.
    // Suggestion: Consider equality overrides (equals, hashCode) if you’ll compare Beverage objects in the future.
}
