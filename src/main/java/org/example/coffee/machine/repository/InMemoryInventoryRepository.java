package org.example.coffee.machine.repository;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.IngredientType;
import org.example.coffee.machine.model.Quantity;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryRepository implements IInventoryRepository {
    private final Map<IngredientType, Quantity> ingredientTypeQuantityMap;

    public InMemoryInventoryRepository() {
        this.ingredientTypeQuantityMap = new HashMap<>();
    }

    @Override
    public void addIngredientFromInventory(Ingredient ingredient) {
        ingredientTypeQuantityMap.put(ingredient.getIngridientType(), ingredient.getIngridientQuantity());
    }

    @Override
    public void removeIngredientFromInventory(Ingredient ingredient) throws IngredientNotExistInTheInventory {
        if(!ingredientTypeQuantityMap.containsKey(ingredient.getIngridientType())) {
            throw new IngredientNotExistInTheInventory(ingredient.getIngridientType());
        }

        ingredientTypeQuantityMap.remove(ingredient.getIngridientType());
    }

    @Override
    public Map<IngredientType, Quantity> getAllIngredientsMap() {
        return ingredientTypeQuantityMap;
    }

    @Override
    public void updateQuantityForIngredient(Ingredient ingredient) throws IngredientNotExistInTheInventory {
        if(!ingredientTypeQuantityMap.containsKey(ingredient.getIngridientType())) {
            throw new IngredientNotExistInTheInventory(ingredient.getIngridientType());
        }
        ingredientTypeQuantityMap.put(ingredient.getIngridientType(), ingredient.getIngridientQuantity());
    }

    @Override
    public Quantity getQuantityForIngredientType(IngredientType ingredientType) throws IngredientNotExistInTheInventory {
        if(!ingredientTypeQuantityMap.containsKey(ingredientType)) {
            throw new IngredientNotExistInTheInventory(ingredientType);
        }

        return ingredientTypeQuantityMap.get(ingredientType);
    }
}
