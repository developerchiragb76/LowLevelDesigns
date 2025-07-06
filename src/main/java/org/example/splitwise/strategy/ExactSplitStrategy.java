package org.example.splitwise.strategy;

import org.example.splitwise.models.*;

import java.util.List;

public class ExactSplitStrategy implements ISplitStrategy {
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.EXACT.equals(expenseType);
    }

    @Override
    public void splitExpense(Expense expense, BalanceSheet balanceSheet) {
        ExactSplitMetaData splitMetadata = (ExactSplitMetaData) expense.getSplitMetadata();
        List<Amount> shares = splitMetadata.getExactAmounts();
        List<User> participants = expense.getParticipants();
        double total = expense.getAmount().getBalance();

        double sum = 0;

        for(Amount share : shares) sum+=share.getBalance();
        if(Math.abs(sum - total) > 0.01) {
            throw new IllegalArgumentException("Exact shares do not sum up to total amount");
        }

        for(int i=0; i < participants.size(); i++) {
            User user = participants.get(i);
            double share = shares.get(i).getBalance();
            if(!user.getUserId().equals(expense.getPayer().getUserId())) {
                balanceSheet.updateBalance(user.getUserId(), expense.getPayer().getUserId(), share);
            }
        }
    }
}
