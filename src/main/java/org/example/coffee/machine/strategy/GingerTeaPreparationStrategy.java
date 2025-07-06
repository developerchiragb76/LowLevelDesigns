package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.IngredientNotExistInTheInventory;
import org.example.coffee.machine.exception.SufficientIngredientQuantityNotAvailableException;
import org.example.coffee.machine.model.BeverageType;
import org.example.coffee.machine.model.Ingredient;

import java.util.List;

public class GingerTeaPreparationStrategy implements IBeveragePreparationStrategy {
    @Override
    public boolean canPrepare(BeverageType beverageType) {
        return BeverageType.GINGER_TEA.equals(beverageType);
    }

    @Override
    public String prepareBeverage(BeverageType beverageType, List<Ingredient> ingredientList) throws IngredientNotExistInTheInventory, SufficientIngredientQuantityNotAvailableException {
        return "";
    }
}
