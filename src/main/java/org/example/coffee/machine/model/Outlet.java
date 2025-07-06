package org.example.coffee.machine.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Outlet {
    private final String outletId;
    private final AtomicBoolean isFree;

    public Outlet(String outletId) {
        this.outletId = outletId;
        isFree = new AtomicBoolean(true);
    }


    public String getOutletId() {
        return outletId;
    }

    public boolean isFree() {
        return isFree.get();
    }

    public boolean occupy() {
        return isFree.compareAndSet(true, false);
    }

    public void release() {
        isFree.set(true);
    }
}
