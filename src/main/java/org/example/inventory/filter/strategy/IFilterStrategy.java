package org.example.inventory.filter.strategy;

import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.Product;

public interface IFilterStrategy<T extends IFilterTypeData> {
    boolean doesSupport(String key);
    boolean doesMatch(IFilterTypeData filterTypeData, Product product);
}
