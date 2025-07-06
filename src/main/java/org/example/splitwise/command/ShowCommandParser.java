package org.example.splitwise.command;

import org.example.splitwise.exceptions.UserNotFoundException;
import org.example.splitwise.service.ExpenseService;

public class ShowCommandParser implements ICommandParser {
    private final ExpenseService expenseService;

    public ShowCommandParser(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public boolean canParse(CommandType commandType) {
        return CommandType.SHOW.equals(commandType);
    }

    @Override
    public void parseCommand(String[] commandParams) throws UserNotFoundException {
        if(commandParams.length == 1) {
            expenseService.showBalances();
        } else {
            expenseService.showBalance(commandParams[1]);
        }
    }
}
