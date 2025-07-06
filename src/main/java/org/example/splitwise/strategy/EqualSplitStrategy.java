package org.example.splitwise.strategy;

import org.example.splitwise.models.*;

import java.util.List;

public class EqualSplitStrategy implements ISplitStrategy {
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.EQUAL.equals(expenseType);
    }

    @Override
    public void splitExpense(Expense expense, BalanceSheet balanceSheet) {
        User payer = expense.getPayer();
        List<User> participants = expense.getParticipants();
        double totalAmount = expense.getAmount().getBalance();
        int n = participants.size();

        double baseShare = Math.floor((totalAmount/n)*100)/100;
        double remainder = totalAmount - baseShare*n;

        for(int i=0; i < n; i++) {
            User user = participants.get(i);
            double finalShare = i == 0 ? baseShare + remainder : baseShare;

            if(!user.getUserId().equals(payer.getUserId())) {
                balanceSheet.updateBalance(user.getUserId(), payer.getUserId(), finalShare);
            }
        }

    }
}
