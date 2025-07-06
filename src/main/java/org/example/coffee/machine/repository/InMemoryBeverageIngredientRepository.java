package org.example.coffee.machine.repository;

import org.example.coffee.machine.exception.BeverageDoesNotExist;
import org.example.coffee.machine.model.BeverageType;
import org.example.coffee.machine.model.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBeverageIngredientRepository implements IBeverageIngredientsRepository {
    private final Map<BeverageType, List<Ingredient>> beverageIngredientsMap;

    public InMemoryBeverageIngredientRepository() {
        beverageIngredientsMap = new HashMap<>();
    }

    @Override
    public List<Ingredient> getAllIngredientsForBeverage(BeverageType beverageType) throws BeverageDoesNotExist {
        if(!beverageIngredientsMap.containsKey(beverageType)) {
            throw new BeverageDoesNotExist(beverageType);
        }

        return beverageIngredientsMap.get(beverageType);
    }

    @Override
    public void addIngredientForBeverage(Ingredient ingredient, BeverageType beverageType) {
        beverageIngredientsMap.putIfAbsent(beverageType, new ArrayList<>());
        beverageIngredientsMap.get(beverageType).add(ingredient);
    }

    @Override
    public void removeIngredientForBeverage(Ingredient ingredient, BeverageType beverageType) throws BeverageDoesNotExist {
        if(!beverageIngredientsMap.containsKey(beverageType)) {
            throw new BeverageDoesNotExist(beverageType);
        }
        beverageIngredientsMap.get(beverageType).remove(ingredient);
    }
}
