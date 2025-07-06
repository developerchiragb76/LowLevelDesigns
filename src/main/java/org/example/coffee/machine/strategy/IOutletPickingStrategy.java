package org.example.coffee.machine.strategy;

import org.example.coffee.machine.exception.NoOutletAvailableException;
import org.example.coffee.machine.model.Outlet;

import java.util.List;

public interface IOutletPickingStrategy {
    Outlet pickAndOccupyOutletIfAvailable(List<Outlet> outlets) throws NoOutletAvailableException;
}
