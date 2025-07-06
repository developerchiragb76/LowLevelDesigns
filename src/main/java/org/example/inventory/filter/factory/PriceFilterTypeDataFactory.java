package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.PriceFilterTypeData;

import java.util.Map;

public class PriceFilterTypeDataFactory implements IFilterTypeDataFactory{
    @Override
    public boolean supports(String key) {
        return "price".equals(key);
    }

    @Override
    public IFilterTypeData createFilterData(Object rawValue) {
        if(!(rawValue instanceof Map)) {
            throw new IllegalArgumentException("Expected a map for price filter");
        }
        return new PriceFilterTypeData((Map<String, Object>) rawValue);
    }
}
