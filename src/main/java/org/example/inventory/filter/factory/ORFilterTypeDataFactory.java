package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.BooleanFilterTypeData;
import org.example.inventory.filter.model.IFilterTypeData;

import java.util.List;
import java.util.Map;

public class ORFilterTypeDataFactory implements IFilterTypeDataFactory{
    @Override
    public boolean supports(String key) {
        return "or".equals(key);
    }

    @Override
    public IFilterTypeData createFilterData(Object rawValue) {
        if(!(rawValue instanceof List<?>)) throw new IllegalArgumentException("Expected List For OR Filter Type");
        return new BooleanFilterTypeData((List<Map<String, Object>>) rawValue);
    }
}
