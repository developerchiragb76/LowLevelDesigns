package org.example.splitwise.strategy;

import org.example.splitwise.models.*;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitMetaDataParser implements ISplitMetaDataParser{
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.EXACT.equals(expenseType);
    }

    @Override
    public ISplitMetadata parse(String[] commandParams, int startIndex, int userCount) {
        List<Amount> exactAmounts = new ArrayList<>();
        for(int i=0; i < userCount; i++) {
            exactAmounts.add(new Amount(Currency.INR, Double.parseDouble(commandParams[startIndex+i])));
        }

        return new ExactSplitMetaData(exactAmounts);
    }
}
