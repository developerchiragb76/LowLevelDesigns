package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.exception.SufficientIngredientQuantityNotAvailableException;
import org.example.coffee.machine.model.Ingredient;

import java.util.List;

public interface IInventoryIngredientsValidationStrategy {
    void validateInventoryIngredientsForBeverageType(List<Ingredient> ingredientList) throws IngredientNotExistInTheInventory, SufficientIngredientQuantityNotAvailableException;
}
