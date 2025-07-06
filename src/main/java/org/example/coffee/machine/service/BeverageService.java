package org.example.coffee.machine.service;

import org.example.coffee.machine.exception.*;
import org.example.coffee.machine.model.BeverageType;
import org.example.coffee.machine.model.Ingredient;
import org.example.coffee.machine.model.Outlet;
import org.example.coffee.machine.repository.IBeverageIngredientsRepository;
import org.example.coffee.machine.strategy.IBeveragePreparationStrategy;
import org.example.coffee.machine.strategy.IInventoryIngredientsValidationStrategy;
import org.example.coffee.machine.strategy.IOutletPickingStrategy;

import java.util.List;

public class BeverageService {

    private final IBeverageIngredientsRepository beverageIngredientsRepository;
    private final List<IBeveragePreparationStrategy> beveragePreparationStrategyList;
    private final IOutletPickingStrategy outletPickingStrategy;
    private final List<Outlet> outlets;

    public BeverageService(List<IBeveragePreparationStrategy> beveragePreparationStrategyList, IInventoryIngredientsValidationStrategy inventoryIngredientsValidationStrategy, IBeverageIngredientsRepository beverageIngredientsRepository, IOutletPickingStrategy outletPickingStrategy, List<Outlet> outlets) {
        this.beverageIngredientsRepository = beverageIngredientsRepository;
        this.beveragePreparationStrategyList = beveragePreparationStrategyList;
        this.outletPickingStrategy = outletPickingStrategy;
        this.outlets = outlets;
    }

    void bendBeverage(BeverageType beverageType) throws BeverageDoesNotExist, SufficientIngredientQuantityNotAvailableException, IngredientNotExistInTheInventory, BeveragePrepartionStrategyNotExistException, NoOutletAvailableException {
        Outlet outlet = outletPickingStrategy.pickAndOccupyOutletIfAvailable(outlets);
        List<Ingredient> ingredientList = beverageIngredientsRepository.getAllIngredientsForBeverage(beverageType);
        for (IBeveragePreparationStrategy beveragePreparationStrategy : beveragePreparationStrategyList) {
            if (beveragePreparationStrategy.canPrepare(beverageType)) {
                String output = beveragePreparationStrategy.prepareBeverage(beverageType, ingredientList);
                System.out.println(output);
                outlet.release();
                return;
            }
        }
        throw new BeveragePrepartionStrategyNotExistException(beverageType);
    }
}
