package org.example.ride.sharing.application.command;

public class CreateVehicleCommandTypeStrategy implements ICommandTypeStrategy {
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.CREATE_VEHICLE.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
