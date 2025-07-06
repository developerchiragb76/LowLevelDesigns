package org.example.inventory.filter.model;

import java.util.Map;

public class PriceFilterTypeData implements IFilterTypeData {
    private final Map<String, Object> priceMap;

    public PriceFilterTypeData(Map<String, Object> priceMap) {
        this.priceMap = priceMap;
    }

    public Map<String, Object> getPriceMap() {
        return priceMap;
    }
}
