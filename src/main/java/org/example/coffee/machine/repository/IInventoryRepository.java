package org.example.coffee.machine.repository;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.IngredientType;
import org.example.coffee.machine.model.Quantity;

import java.util.Map;

public interface IInventoryRepository {
    void addIngredientFromInventory(Ingredient ingredient);
    void removeIngredientFromInventory (Ingredient ingredient) throws IngredientNotExistInTheInventory;
    Map<IngredientType, Quantity> getAllIngredientsMap();
    void updateQuantityForIngredient(Ingredient ingredient) throws IngredientNotExistInTheInventory;
    Quantity getQuantityForIngredientType(IngredientType ingredientType) throws IngredientNotExistInTheInventory;
}
