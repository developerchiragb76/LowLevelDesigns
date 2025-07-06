package org.example.splitwise.models;

import java.util.List;

public class Expense {
    private final User payer;
    private final List<User> participants;
    private final Amount amount;
    private final ExpenseType expenseType;
    private final ISplitMetadata splitMetadata;


    public Expense(User payer, List<User> participants, Amount amount, ExpenseType expenseType, ISplitMetadata splitMetadata) {
        this.payer = payer;
        this.participants = participants;
        this.amount = amount;
        this.expenseType = expenseType;
        this.splitMetadata = splitMetadata;
    }


    public User getPayer() {
        return payer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Amount getAmount() {
        return amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public ISplitMetadata getSplitMetadata() {
        return splitMetadata;
    }
}
