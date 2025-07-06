package org.example.splitwise.service;

import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.models.*;
import org.example.splitwise.repository.IExpenseRepository;
import org.example.splitwise.repository.IUserRepository;
import org.example.splitwise.strategy.ISplitStrategy;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    private IExpenseRepository expenseRepository;
    private IUserRepository userRepository;
    private List<ISplitStrategy> splitStrategies;
    private BalanceSheet balanceSheet;


    public ExpenseService(IExpenseRepository expenseRepository, IUserRepository userRepository, List<ISplitStrategy> splitStrategies, BalanceSheet balanceSheet) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.splitStrategies = splitStrategies;
        this.balanceSheet = balanceSheet;
    }

    public void saveAndSplitExpense(User payer, Amount paidAmount, List<User> participants, ExpenseType expenseType, ISplitMetadata splitMetadata) {
        Expense expense = new Expense(payer, participants, paidAmount, expenseType, splitMetadata);
        expenseRepository.saveExpense(expense);

        for(ISplitStrategy splitStrategy : splitStrategies) {
            if(splitStrategy.canHandle(expenseType)) {
                splitStrategy.splitExpense(expense, balanceSheet);
            }
        }
    }

    public void showBalance(String userId) throws UserNotFoundException {
        boolean isEmpty = true;
        for(Map.Entry<String, Amount> userBalance : balanceSheet.getUserBalance(userId).entrySet()) {
            if(userBalance.getValue().getBalance() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue().getBalance());
            }
        }

        if(isEmpty) {
            System.out.println("No Balances");
        }
    }

    public void showBalances() throws UserNotFoundException {
        boolean isEmpty = true;
        for(Map.Entry<String, Map<String,Amount>> fromEntry : balanceSheet.getBalanceSheet().entrySet()) {
            String fromUser = fromEntry.getKey();
            for(Map.Entry<String, Amount> toEntry : fromEntry.getValue().entrySet()) {
                String toUser = toEntry.getKey();
                double amount = toEntry.getValue().getBalance();


                if(amount > 0 && fromUser.compareTo(toUser) < 0) {
                    isEmpty = false;
                    printBalance(toUser, fromUser, amount);
                }
            }
        }

        if(isEmpty) {
            System.out.println("No Balances");
        }
    }

    public void printBalance(String user1, String user2, double amount) throws UserNotFoundException {
        User u1 = userRepository.getUserById(user1);
        User u2 = userRepository.getUserById(user2);

        if(amount < 0) {
            System.out.println(u1.getUserName() + " owes " + u2.getUserName() + ":" + Math.abs(amount));
        } else if(amount > 0) {
            System.out.println(u2.getUserName() + " owes " + u1.getUserName() + ":" + Math.abs(amount));
        }
    }


}
