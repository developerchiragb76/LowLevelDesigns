package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.NameFilterTypeData;

public class NameFilterTypeDataFactory implements IFilterTypeDataFactory{
    @Override
    public boolean supports(String key) {
        return "name".equals(key);
    }

    @Override
    public IFilterTypeData createFilterData(Object rawValue) {
        if(!(rawValue instanceof String))
            throw new IllegalArgumentException("Expected String Value For Name Filter");

        return new NameFilterTypeData((String) rawValue);
    }
}
