package org.example.splitwise.exceptions;

import org.example.splitwise.models.ExpenseType;

public class UnSupportedSplitMetaDataForExpenseType extends Throwable {
    public UnSupportedSplitMetaDataForExpenseType(ExpenseType expenseType) {
        super("Unsupported split meta data for " + expenseType + " expense type");
    }
}
