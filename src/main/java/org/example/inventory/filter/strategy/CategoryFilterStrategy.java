package org.example.inventory.filter.strategy;

import org.example.inventory.filter.model.CategoryFilterTypeData;
import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.Product;


public class CategoryFilterStrategy implements IFilterStrategy<CategoryFilterTypeData> {
    @Override
    public boolean doesSupport(String key) {
        return "category".equals(key);
    }

    @Override
    public boolean doesMatch(IFilterTypeData filterTypeData, Product product) {
        CategoryFilterTypeData categoryFilterTypeData = (CategoryFilterTypeData) filterTypeData;
        String value = (String ) categoryFilterTypeData.getCategoryValue();
        return product.getCategory().equalsIgnoreCase(value);
    }
}
