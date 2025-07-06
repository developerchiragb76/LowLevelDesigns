package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.exception.SufficientIngredientQuantityNotAvailableException;
import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.Quantity;
import org.example.coffee.machine.repository.IInventoryRepository;

import java.util.List;

public class InventoryIngredientsValidationStrategyImpl implements IInventoryIngredientsValidationStrategy {
    private final IInventoryRepository inventoryRepository;

    public InventoryIngredientsValidationStrategyImpl(IInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void validateInventoryIngredientsForBeverageType(List<Ingredient> ingredientList) throws IngredientNotExistInTheInventory, SufficientIngredientQuantityNotAvailableException {

        for(Ingredient ingredient : ingredientList) {
            Quantity inventoryIngQuantity = inventoryRepository.getQuantityForIngredientType(ingredient.getIngridientType());
            if(ingredient.getIngridientQuantity().getQuantity() > inventoryIngQuantity.getQuantity()) {
                throw new SufficientIngredientQuantityNotAvailableException(inventoryIngQuantity, ingredient);
            }
        }
    }
}
