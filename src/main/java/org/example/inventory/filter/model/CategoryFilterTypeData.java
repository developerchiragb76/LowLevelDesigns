package org.example.inventory.filter.model;

public class CategoryFilterTypeData implements IFilterTypeData {
    private final String categoryValue;

    public CategoryFilterTypeData(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() {
        return categoryValue;
    }
}
