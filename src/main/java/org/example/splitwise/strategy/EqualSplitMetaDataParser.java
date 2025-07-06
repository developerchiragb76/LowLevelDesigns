package org.example.splitwise.strategy;

import org.example.splitwise.models.EqualSplitMetaData;
import org.example.splitwise.models.ExpenseType;
import org.example.splitwise.models.ISplitMetadata;

public class EqualSplitMetaDataParser implements ISplitMetaDataParser{
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.EQUAL.equals(expenseType);
    }

    @Override
    public ISplitMetadata parse(String[] commandParams, int startIndex, int userCount) {
        return new EqualSplitMetaData();
    }
}
