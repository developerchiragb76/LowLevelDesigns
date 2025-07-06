package org.example.splitwise.strategy;

import org.example.splitwise.models.BalanceSheet;
import org.example.splitwise.models.Expense;
import org.example.splitwise.models.ExpenseType;

public interface ISplitStrategy {
    boolean canHandle(ExpenseType expenseType);
    void splitExpense(Expense expense, BalanceSheet balanceSheet);
}
