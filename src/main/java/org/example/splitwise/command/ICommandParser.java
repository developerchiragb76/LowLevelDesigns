package org.example.splitwise.command;

import org.example.splitwise.exceptions.UnSupportedSplitMetaDataForExpenseType;
import org.example.splitwise.exceptions.UserNotFoundException;

public interface ICommandParser {
    boolean canParse(CommandType commandType);
    void parseCommand(String[] commandParams) throws UserNotFoundException, UnSupportedSplitMetaDataForExpenseType;
}
