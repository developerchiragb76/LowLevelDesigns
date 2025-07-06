package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.IFilterTypeData;

import java.util.List;

public class FilterTypeDataRegistry {
    private final List<IFilterTypeDataFactory> factories;

    public FilterTypeDataRegistry(List<IFilterTypeDataFactory> factories) {
        this.factories = factories;
    }

    public IFilterTypeData getFilterTypeData(String key, Object rawValue) {
        return factories.stream()
                .filter(f -> f.supports(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No factory for key: " + key))
                .createFilterData(rawValue);
    }
}
