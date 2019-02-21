package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;
import com.zybank.parkinglot.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> map = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingSpot() {
        return capacity - map.size();
    }

    public int getMaxParkingSpot(){
        return capacity;
    }

    public Ticket parkCar(Car car) {
        if(null == car){
            throw new ParkingException("The car is null.");
        }
        if (map.size() >= capacity) {
            throw new ParkingException("The ParkingLot has not empty parking spot.");
        }
        Ticket ticket = new Ticket();
        map.put(ticket, car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        if(map.get(ticket) == null){
            throw new ParkingException("Has not car match this ticket");
        }
        return map.remove(ticket);
    }
}
