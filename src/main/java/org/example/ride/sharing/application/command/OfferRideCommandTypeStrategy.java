package org.example.ride.sharing.application.command;

public class OfferRideCommandTypeStrategy implements ICommandTypeStrategy{
    @Override
    public boolean canHandleCommand(CommandType commandType) {
        return CommandType.OFFER_RIDE.equals(commandType);
    }

    @Override
    public void handleCommand(String command) {

    }
}
