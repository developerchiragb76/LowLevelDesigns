package org.example.splitwise.command;

import org.example.splitwise.exceptions.UnSupportedCommandTypeException;
import org.example.splitwise.exceptions.UnSupportedSplitMetaDataForExpenseType;
import org.example.splitwise.exceptions.UserNotFoundException;
import java.util.List;

public class Command {
    private final List<ICommandParser> commandParsers;

    public Command(List<ICommandParser> commandParsers) {
        this.commandParsers = commandParsers;
    }

    public void parseCommand(String input) throws UnSupportedCommandTypeException, UserNotFoundException, UnSupportedSplitMetaDataForExpenseType {
        String[] commandParams = input.split(" ");
        String commandType = commandParams[0];
        CommandType command = CommandType.valueOf(commandType);

        for(ICommandParser commandParser : commandParsers) {
            if(commandParser.canParse(command)) {
                commandParser.parseCommand(commandParams);
            }
        }
    }
}
