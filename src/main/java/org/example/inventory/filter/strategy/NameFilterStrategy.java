package org.example.inventory.filter.strategy;

import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.NameFilterTypeData;
import org.example.inventory.filter.model.Product;


public class NameFilterStrategy implements IFilterStrategy<NameFilterTypeData> {
    @Override
    public boolean doesSupport(String key) {
        return "name".equals(key);
    }

    @Override
    public boolean doesMatch(IFilterTypeData filterTypeData, Product product) {
        NameFilterTypeData nameFilterTypeData = (NameFilterTypeData) filterTypeData;
        String value = nameFilterTypeData.getValue();
        return product.getName().toLowerCase().contains(value.toLowerCase());
    }
}
