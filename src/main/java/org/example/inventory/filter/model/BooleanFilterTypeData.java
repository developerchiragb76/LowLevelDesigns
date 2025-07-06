package org.example.inventory.filter.model;

import java.util.List;
import java.util.Map;

public class BooleanFilterTypeData implements IFilterTypeData {
    private final List<Map<String, Object>> booleanFilterTypeMapList;

    public BooleanFilterTypeData(List<Map<String, Object>> booleanFilterTypeMapList) {
        this.booleanFilterTypeMapList = booleanFilterTypeMapList;
    }

    public List<Map<String, Object>> getBooleanFilterTypeMapList() {
        return booleanFilterTypeMapList;
    }
}
