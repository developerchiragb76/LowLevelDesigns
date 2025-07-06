package org.example.inventory.filter.strategy;

import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.PriceFilterTypeData;
import org.example.inventory.filter.model.Product;

import java.util.Map;

public class PriceFilterStrategy implements IFilterStrategy<PriceFilterTypeData>{
    @Override
    public boolean doesSupport(String key) {
        return "price".equals(key);
    }

    @Override
    public boolean doesMatch(IFilterTypeData filterTypeData, Product product) {
        Double ltprice = Double.MIN_VALUE;
        Double gtPrice = Double.MAX_VALUE;
        PriceFilterTypeData priceFilterTypeData = (PriceFilterTypeData) filterTypeData;
        Map<String, Object> priceMap = priceFilterTypeData.getPriceMap();

        if(priceMap.containsKey("lt")) {
            Object val = priceMap.get("lt");
            if(val instanceof Number) {
                ltprice = ((Number) val).doubleValue();
            }
        }

        if(priceMap.containsKey("gt")) {
            Object val = priceMap.get("gt");
            if(val instanceof Number) {
                gtPrice = ((Number) val).doubleValue();
            }
        }

        double price = product.getPrice();
        return price >= gtPrice && price < ltprice;
    }
}
