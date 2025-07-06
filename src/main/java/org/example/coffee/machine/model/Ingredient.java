package org.example.coffee.machine.model;

public class Ingredient {
    private final IngredientType ingredientType;
    private final Quantity ingridientQuantity;

    public Ingredient(IngredientType ingredientType, Quantity ingridientQuantity) {
        this.ingredientType = ingredientType;
        this.ingridientQuantity = ingridientQuantity;
    }

    public IngredientType getIngridientType() {
        return ingredientType;
    }

    public Quantity getIngridientQuantity() {
        return ingridientQuantity;
    }

    // Suggestion: Add toString() overrides for easier debugging/logging.
    // Suggestion: Consider equality overrides (equals, hashCode) if you’ll compare Ingredient objects in the future.
}
