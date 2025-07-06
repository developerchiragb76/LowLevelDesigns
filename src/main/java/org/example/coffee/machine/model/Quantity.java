package org.example.coffee.machine.model;

public class Quantity {
    private final int quantity;
    private final Unit unit;

    public Quantity(int quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    // Suggestion: Add toString() overrides for easier debugging/logging.
    // Suggestion: Consider equality overrides (equals, hashCode) if you’ll compare Quantity objects in the future.
}
