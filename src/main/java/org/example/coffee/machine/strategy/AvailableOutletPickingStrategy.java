package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.NoOutletAvailableException;
import org.example.coffee.machine.model.Outlet;

import java.util.List;

public class AvailableOutletPickingStrategy implements IOutletPickingStrategy {
    @Override
    public Outlet pickAndOccupyOutletIfAvailable(List<Outlet> outlets) throws NoOutletAvailableException {
        for(Outlet outlet : outlets) {
            if(outlet.occupy()) {
                return outlet;
            }
        }
        throw new NoOutletAvailableException("No outlet available");
    }
}
