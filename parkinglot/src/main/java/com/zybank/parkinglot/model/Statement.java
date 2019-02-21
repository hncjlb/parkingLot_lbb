package com.zybank.parkinglot.model;

import com.zybank.parkinglot.ParkingManager;

public class Statement {
    private ParkingManager manager;

    public ParkingManager getManager() {
        return manager;
    }

    public void setManager(ParkingManager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "the statement content";
    }
}
