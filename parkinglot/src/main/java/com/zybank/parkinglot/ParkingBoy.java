package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;
import com.zybank.parkinglot.model.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;
    protected int index;
    protected Map<Ticket,ParkingLot> parkingLotMap = new HashMap<>();
    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket parking(Car car) {
        if(car == null){
            throw new ParkingException("The car is null");
        }
        if (null != parkingLotList && parkingLotList.size() > 0) {
            ParkingLot parkingLot = parkingLotList.get((index++)%parkingLotList.size());
            if(null != parkingLot){
                Ticket ticket = parkingLot.parkCar(car);
                parkingLotMap.put(ticket,parkingLot);
                return ticket;
            }
        }
        throw new ParkingException("parking lot is null");
    }

    public Car getCar(Ticket ticket) {
        if(null == ticket){
            throw new ParkingException("ticket is null");
        }
        if(parkingLotMap == null || parkingLotMap.size()<=0){
            throw new ParkingException("parking lot is null");
        }
        ParkingLot lot = parkingLotMap.get(ticket);
        Car car = lot.getCar(ticket);
        parkingLotMap.remove(ticket);
        return car;
    }
}
