package org.example.inventory.filter.model;

public class NameFilterTypeData implements IFilterTypeData {
    private final String value;

    public NameFilterTypeData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
