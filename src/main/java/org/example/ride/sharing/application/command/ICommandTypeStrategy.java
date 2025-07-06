package org.example.ride.sharing.application.command;

public interface ICommandTypeStrategy {
    boolean canHandleCommand(CommandType commandType);
    void handleCommand(String command);
}
