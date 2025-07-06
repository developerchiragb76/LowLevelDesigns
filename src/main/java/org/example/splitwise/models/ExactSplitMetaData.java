package org.example.splitwise.models;

import java.util.List;

public class ExactSplitMetaData implements ISplitMetadata {
    private final List<Amount> exactAmounts;

    public ExactSplitMetaData(List<Amount> exactAmounts) {
        this.exactAmounts = exactAmounts;
    }

    public List<Amount> getExactAmounts() {
        return exactAmounts;
    }
}
