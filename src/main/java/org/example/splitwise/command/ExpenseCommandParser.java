package org.example.splitwise.command;

import org.example.splitwise.exceptions.UnSupportedSplitMetaDataForExpenseType;
import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.models.*;
import org.example.splitwise.repository.IUserRepository;
import org.example.splitwise.service.ExpenseService;
import org.example.splitwise.strategy.ISplitMetaDataParser;

import java.util.ArrayList;
import java.util.List;

public class ExpenseCommandParser implements ICommandParser {
    private final IUserRepository userRepository;
    private final ExpenseService expenseService;
    private final List<ISplitMetaDataParser> splitMetaDataParsers;

    public ExpenseCommandParser(IUserRepository userRepository, ExpenseService expenseService, List<ISplitMetaDataParser> splitMetaDataParsers) {
        this.userRepository = userRepository;
        this.expenseService = expenseService;
        this.splitMetaDataParsers = splitMetaDataParsers;
    }

    @Override
    public boolean canParse(CommandType commandType) {
        return CommandType.EXPENSE.equals(commandType);
    }

    @Override
    public void parseCommand(String[] commandParams) throws UserNotFoundException, UnSupportedSplitMetaDataForExpenseType {
        List<User> participants = new ArrayList<>();
        String payer = commandParams[1];
        User u1 = userRepository.getUserById(payer);
        double paidAmount = Double.parseDouble(commandParams[2]);
        Amount amount = new Amount(Currency.INR, paidAmount);
        int noOfUsers = Integer.parseInt(commandParams[3]);
        ExpenseType expenseType = ExpenseType.valueOf(commandParams[4+noOfUsers]);
        for(int i=0; i < noOfUsers; i++) {
            User user = userRepository.getUserById(commandParams[4+i]);
            participants.add(user);
        }
        ISplitMetadata splitMetadata = null;
        for(ISplitMetaDataParser splitMetaDataParser : splitMetaDataParsers) {
            if(splitMetaDataParser.canHandle(expenseType)) {
                if(splitMetadata == null)
                    splitMetadata = splitMetaDataParser.parse(commandParams, 5 + noOfUsers, noOfUsers);
                else
                    break;
            }
        }

        if(splitMetadata == null) {
            throw new UnSupportedSplitMetaDataForExpenseType(expenseType);
        }

        expenseService.saveAndSplitExpense(u1, amount, participants, expenseType, splitMetadata);
    }
}
