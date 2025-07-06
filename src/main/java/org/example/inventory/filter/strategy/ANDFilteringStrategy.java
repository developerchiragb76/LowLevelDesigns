package org.example.inventory.filter.strategy;

import org.example.inventory.filter.factory.FilterTypeDataRegistry;
import org.example.inventory.filter.model.BooleanFilterTypeData;
import org.example.inventory.filter.model.IFilterTypeData;
import org.example.inventory.filter.model.Product;

import java.util.List;
import java.util.Map;

public class ANDFilteringStrategy implements IFilterStrategy<BooleanFilterTypeData> {
    private final List<IFilterStrategy> filterStrategyList;
    private final FilterTypeDataRegistry filterTypeDataRegistry;

    public ANDFilteringStrategy(List<IFilterStrategy> filterStrategyList, FilterTypeDataRegistry filterTypeDataRegistry) {
        this.filterStrategyList = filterStrategyList;
        this.filterTypeDataRegistry = filterTypeDataRegistry;
    }

    @Override
    public boolean doesSupport(String key) {
        return "and".equals(key);
    }

    @Override
    public boolean doesMatch(IFilterTypeData filterTypeData, Product product) {
        BooleanFilterTypeData booleanFilterTypeData = (BooleanFilterTypeData) filterTypeData;
        List<Map<String, Object>> conditions = booleanFilterTypeData.getBooleanFilterTypeMapList();
        for(Map<String, Object> condition : conditions) {
            for(Map.Entry<String, Object> entry : condition.entrySet()) {
                String filterKey = entry.getKey();
                IFilterTypeData filterValue = filterTypeDataRegistry.getFilterTypeData(filterKey, entry.getValue());
                IFilterStrategy<BooleanFilterTypeData> strategy = getFilterStrategy(filterKey);
                if(strategy!=null && !strategy.doesMatch(filterValue, product)) return false;
            }
        }
        return true;
    }

    private IFilterStrategy getFilterStrategy(String filterKey) {
        for(IFilterStrategy filterStrategy : filterStrategyList) {
            if(filterStrategy.doesSupport(filterKey)) {
                return filterStrategy;
            }
        }
        return null;
    }
}
