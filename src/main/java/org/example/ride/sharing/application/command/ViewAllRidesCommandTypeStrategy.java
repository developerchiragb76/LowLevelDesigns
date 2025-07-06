package org.example.ride.sharing.application.command;

public class ViewAllRidesCommandTypeStrategy implements ICommandTypeStrategy {
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.VIEW_ALL_RIDES.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
