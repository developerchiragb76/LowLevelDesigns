package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.exception.SufficientIngredientQuantityNotAvailableException;
import org.example.coffee.machine.model.BeverageType;
import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.Quantity;
import org.example.coffee.machine.repository.IInventoryRepository;

import java.util.List;

public class CoffeePreparationStrategy implements IBeveragePreparationStrategy {
    private final IInventoryRepository inventoryRepository;
    private final IInventoryIngredientsValidationStrategy inventoryIngredientsValidationStrategy;

    public CoffeePreparationStrategy(IInventoryRepository inventoryRepository, IInventoryIngredientsValidationStrategy inventoryIngredientsValidationStrategy) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryIngredientsValidationStrategy = inventoryIngredientsValidationStrategy;
    }

    @Override
    public boolean canPrepare(BeverageType beverageType) {
        return BeverageType.COFFEE.equals(beverageType);
    }

    @Override
    public String prepareBeverage(BeverageType beverageType, List<Ingredient> ingredientList) throws IngredientNotExistInTheInventory, SufficientIngredientQuantityNotAvailableException {
        inventoryIngredientsValidationStrategy.validateInventoryIngredientsForBeverageType(ingredientList);

        for(Ingredient ingredient : ingredientList) {
            Quantity available = inventoryRepository.getQuantityForIngredientType(ingredient.getIngridientType());
            int required = ingredient.getIngridientQuantity().getQuantity();

            // Deduct
            Quantity newQuantity = new Quantity(available.getQuantity() - required, available.getUnit());
            Ingredient updated = new Ingredient(ingredient.getIngridientType(), newQuantity);
            inventoryRepository.updateQuantityForIngredient(updated);
        }
        return beverageType.name().toLowerCase().replace("_"," ") + "is prepared";
    }
}
