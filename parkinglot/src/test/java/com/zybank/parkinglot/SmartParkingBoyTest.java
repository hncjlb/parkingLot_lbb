package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test(expected = ParkingException.class)
    public void throw_exception_when_parking_lot_null() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        ParkingBoy boy = new ParkingBoy(parkingLotList);
        boy.parking(new Car());
    }

    @Test(expected = ParkingException.class)
    public void throw_exception_when_car_null() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        ParkingBoy boy = new ParkingBoy(parkingLotList);
        boy.parking(null);
    }

    @Test
    public void return_ticket_when_given_a_car() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(3));
        parkingLotList.add(new ParkingLot(5));
        ParkingBoy boy = new ParkingBoy(parkingLotList);
        Assert.assertNotNull(boy.parking(new Car()));
    }

    @Test
    public void park_to_max_park_spot_when_given_a_car() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        SmartParkingBoy boy = new SmartParkingBoy(parkingLotList);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 4);
    }

    @Test
    public void park_to_max_park_spot_when_given_some_car() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        SmartParkingBoy boy = new SmartParkingBoy(parkingLotList);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 4);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 3);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 2);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 2);
    }
}
