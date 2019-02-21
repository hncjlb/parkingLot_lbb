package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;
import com.zybank.parkinglot.model.Ticket;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket parking(Car car) {
        if (car == null) {
            throw new ParkingException("The car is null");
        }
        if (null != parkingLotList && parkingLotList.size() > 0) {
            ParkingLot lot = null;
            int maxParkintPort = 0;
            for (int i = 0; i < parkingLotList.size(); i++) {
                int parkintSpot = parkingLotList.get(i).getAvailableParkingSpot();
                if (parkintSpot > maxParkintPort) {
                    maxParkintPort = parkintSpot;
                    lot = parkingLotList.get(i);
                }
            }
            return lot.parkCar(car);
        }
        throw new ParkingException("parking lot is null");
    }
}
