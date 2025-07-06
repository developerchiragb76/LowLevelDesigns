package org.example.ride.sharing.application.command;

public class ViewAllRidesTakenCommandTypeStrategy implements ICommandTypeStrategy{
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.VIEW_ALL_TAKEN.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
