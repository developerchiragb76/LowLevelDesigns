package org.example.coffee.machine.exception;

import org.example.coffee.machine.model.IngredientType;

public class IngredientNotExistInTheInventory extends Exception {
    public IngredientNotExistInTheInventory(IngredientType ingredientType) {
        super("Ingredient " + ingredientType + " Not Exist In The Inventory");
    }
}
