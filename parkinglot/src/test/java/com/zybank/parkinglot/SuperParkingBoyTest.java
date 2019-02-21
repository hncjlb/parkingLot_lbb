package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest extends ParkingBoyTest{

    @Test
    public void park_to_max_vacancy_rate_when_given_a_car() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        SuperParkingBoy boy = new SuperParkingBoy(parkingLotList);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 2);
    }

    @Test
    public void park_to_max_vacancy_rate_when_given_some_car() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        SuperParkingBoy boy = new SuperParkingBoy(parkingLotList);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 2);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 4);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 3);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 1);
    }
}
