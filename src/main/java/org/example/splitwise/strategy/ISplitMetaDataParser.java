package org.example.splitwise.strategy;

import org.example.splitwise.models.ExpenseType;
import org.example.splitwise.models.ISplitMetadata;

public interface ISplitMetaDataParser {
    boolean canHandle(ExpenseType expenseType);
    ISplitMetadata parse(String[] commandParams, int startIndex, int userCount);
}
