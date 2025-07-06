package org.example.inventory.filter.service;

import org.example.inventory.filter.factory.FilterTypeDataRegistry;
import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.Product;
import org.example.inventory.filter.repository.InventoryRepository;
import org.example.inventory.filter.strategy.IFilterStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private final InventoryRepository inventoryRepository;
    private final List<IFilterStrategy> filterStrategyList;
    private final FilterTypeDataRegistry filterTypeDataRegistry;

    public InventoryManager(InventoryRepository inventoryRepository, List<IFilterStrategy> filterStrategyList, FilterTypeDataRegistry filterTypeDataRegistry) {
        this.inventoryRepository = inventoryRepository;
        this.filterStrategyList = filterStrategyList;
        this.filterTypeDataRegistry = filterTypeDataRegistry;
    }

    public List<Product> filterProducts(Map<String, Object> filterProps) {
        List<Product> allProds = inventoryRepository.getAllProducts();
        final List<Product> filterProducts = new ArrayList<>();

        for(Product product : allProds) {
            for(String key : filterProps.keySet()) {
                IFilterStrategy filterStrategy = getFilterStrategy(key);
                IFilterTypeData filterTypeData = filterTypeDataRegistry.getFilterTypeData(key, filterProps.get(key));
                if(filterStrategy!=null && filterStrategy.doesMatch(filterTypeData, product)) {
                    filterProducts.add(product);
                }
            }
        }
        return filterProducts;
    }

    private IFilterStrategy getFilterStrategy(String key) {
        for(IFilterStrategy filterStrategy : filterStrategyList) {
            if(filterStrategy.doesSupport(key)) {
                return filterStrategy;
            }
        }
        return null;
    }
}
