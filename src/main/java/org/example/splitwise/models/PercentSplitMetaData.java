package org.example.splitwise.models;

import java.util.List;

public class PercentSplitMetaData implements ISplitMetadata {
    private final List<Double> percentages;

    public PercentSplitMetaData(List<Double> percentages) {
        this.percentages = percentages;
    }

    public List<Double> getPercentages() {
        return percentages;
    }
}
