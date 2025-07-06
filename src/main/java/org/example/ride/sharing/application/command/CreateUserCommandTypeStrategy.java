package org.example.ride.sharing.application.command;

public class CreateUserCommandTypeStrategy implements ICommandTypeStrategy {
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.CREATE_USER.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
