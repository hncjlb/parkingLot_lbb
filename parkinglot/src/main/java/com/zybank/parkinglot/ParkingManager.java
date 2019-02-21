package com.zybank.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys = new ArrayList<>();
    public ParkingManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public void addParkingBoy(ParkingBoy boy){
        if(null == boy){
            throw new ParkingManagerException("the boy is null");
        }
        parkingBoys.add(boy);
    }

    public void removeParkingBoy(ParkingBoy boy){
        parkingBoys.remove(boy);
    }

    public ParkingBoy getParkingBoy(){
        if(null == parkingBoys || parkingBoys.size()<=0){
            throw new ParkingManagerException("has nobody under the manager");
        }
        return parkingBoys.get(0);
    }
}
