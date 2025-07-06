package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.CategoryFilterTypeData;
import org.example.inventory.filter.model.IFilterTypeData;

public class CategoryFilterTypeDataFactory implements IFilterTypeDataFactory {
    @Override
    public boolean supports(String key) {
        return "category".equals(key);
    }

    @Override
    public IFilterTypeData createFilterData(Object rawValue) {
        if(!(rawValue instanceof String)) throw new IllegalArgumentException("Expected String for Category Filter Type");
        return new CategoryFilterTypeData((String) rawValue);
    }
}
