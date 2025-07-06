package org.example.ride.sharing.application.command;

public class SelectRideCommandTypeStrategy implements ICommandTypeStrategy {
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.SELECT_RIDE.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
