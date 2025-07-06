package org.example.coffee.machine.exception;

import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.Quantity;

public class SufficientIngredientQuantityNotAvailableException extends Exception {
    public SufficientIngredientQuantityNotAvailableException(Quantity inventoryIngQuantity, Ingredient ingredient) {
       super("Inventory Quantity " + inventoryIngQuantity.getQuantity() + "Is Greater Than Required Quantity " + ingredient.getIngridientQuantity().getQuantity() + " For Ingredient Type " + ingredient.getIngridientType());
    }
}
