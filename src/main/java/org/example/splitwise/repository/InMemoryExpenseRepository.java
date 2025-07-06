package org.example.splitwise.repository;

import org.example.splitwise.models.Expense;

import java.util.ArrayList;
import java.util.List;

public class InMemoryExpenseRepository implements IExpenseRepository {
    private final List<Expense> expenses;

    public InMemoryExpenseRepository() {
        expenses = new ArrayList<>();
    }

    @Override
    public void saveExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenses;
    }
}
