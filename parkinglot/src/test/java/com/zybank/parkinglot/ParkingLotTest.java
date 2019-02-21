package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void return_ticket_when_park_a_car(){
        Car car = new Car();
        ParkingLot lot = new ParkingLot(1);

        Assert.assertNotNull(lot.parkCar(car));
    }

    @Test (expected = ParkingException.class)
    public  void throw_exception_when_parking_lot_full(){
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot lot = new ParkingLot(1);
        lot.parkCar(car1);
        lot.parkCar(car2);
    }

    @Test (expected = ParkingException.class)
    public  void throw_exception_when_parking_null(){
        Car car1 = null;
        ParkingLot lot = new ParkingLot(1);
        lot.parkCar(car1);
    }
}
