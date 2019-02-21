package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;
import com.zybank.parkinglot.model.Ticket;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket parking(Car car) {
        if (car == null) {
            throw new ParkingException("The car is null");
        }
        if (null != parkingLotList && parkingLotList.size() > 0) {
            ParkingLot lot = null;
            float maxRate = 0.0f;
            for (int i = 0; i < parkingLotList.size(); i++) {
                int parkintSpot = parkingLotList.get(i).getAvailableParkingSpot();
                int capacity = parkingLotList.get(i).getMaxParkingSpot();
                float rate = parkintSpot * 1.0f / capacity;
                if (rate > maxRate) {
                    maxRate = rate;
                    lot = parkingLotList.get(i);
                }
            }
            return lot.parkCar(car);
        }
        throw new ParkingException("parking lot is null");
    }
}
