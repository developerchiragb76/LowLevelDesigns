package org.example.coffee.machine.repository;

import org.example.coffee.machine.exception.BeverageDoesNotExist;
import org.example.coffee.machine.model.BeverageType;
import org.example.coffee.machine.model.Ingredient;

import java.util.List;

public interface IBeverageIngredientsRepository {
    List<Ingredient> getAllIngredientsForBeverage(BeverageType beverageType) throws BeverageDoesNotExist;
    void addIngredientForBeverage(Ingredient ingredient, BeverageType beverageType);
    void removeIngredientForBeverage(Ingredient ingredient, BeverageType beverageType) throws BeverageDoesNotExist;
}
