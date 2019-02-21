package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Statement;

public class ParkingDirector {
    private ParkingManager manager;
    public void setManager(ParkingManager manager){
        this.manager = manager;
    }

    public Statement getStatement(){
        Statement statement = new Statement();
        statement.setManager(manager);
        return new Statement();
    }
}
