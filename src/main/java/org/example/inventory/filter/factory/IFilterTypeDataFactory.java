package org.example.inventory.filter.factory;

import org.example.inventory.filter.model.IFilterTypeData;

public interface IFilterTypeDataFactory {
    boolean supports(String key);
    IFilterTypeData createFilterData(Object rawValue);
}
