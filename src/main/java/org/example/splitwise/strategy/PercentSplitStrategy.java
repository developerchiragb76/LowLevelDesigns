package org.example.splitwise.strategy;

import org.example.splitwise.models.*;

import java.util.List;

public class PercentSplitStrategy implements ISplitStrategy{
    @Override
    public boolean canHandle(ExpenseType expenseType) {
        return ExpenseType.PERCENT.equals(expenseType);
    }

    @Override
    public void splitExpense(Expense expense, BalanceSheet balanceSheet) {
        PercentSplitMetaData metadata = (PercentSplitMetaData) expense.getSplitMetadata();
        List<Double> percents = metadata.getPercentages();
        List<User> participants = expense.getParticipants();
        double totalAmount = expense.getAmount().getBalance();

        double sum = 0;
        for(double percent: percents) sum+=percent;

        if(Math.abs(sum - 100.0) > 0.01)
            throw new IllegalArgumentException("Percentages must sum to 100.");

        for(int i=0; i < participants.size(); i++) {
            User user = participants.get(i);
            double share = (percents.get(i) * totalAmount) / 100.0;
            share = Math.round(share*100.0)/100.0;

            if(!user.getUserId().equals(expense.getPayer().getUserId())) {
                balanceSheet.updateBalance(user.getUserId(), expense.getPayer().getUserId(), share);
            }
        }


    }
}
