package org.example.splitwise.strategy;

import org.example.splitwise.models.ExpenseType;
import org.example.splitwise.models.ISplitMetadata;
import org.example.splitwise.models.PercentSplitMetaData;

import java.util.ArrayList;
import java.util.List;

public class PercentSplitMetaDataParser implements ISplitMetaDataParser{
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.PERCENT.equals(expenseType);
    }

    @Override
    public ISplitMetadata parse(String[] commandParams, int startIndex, int userCount) {
        List<Double> percentages = new ArrayList<>();
        for(int i=0; i < userCount; i++) {
            percentages.add(Double.parseDouble(commandParams[startIndex + i]));
        }

        return new PercentSplitMetaData(percentages);
    }
}
