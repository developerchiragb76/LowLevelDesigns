package org.example.splitwise.repository;

import org.example.splitwise.models.Expense;

import java.util.List;

public interface IExpenseRepository {
    void saveExpense(Expense expense);
    List<Expense> getAllExpenses();
}
