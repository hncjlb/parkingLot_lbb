package com.zybank.parkinglot;

import com.zybank.parkinglot.model.Car;
import com.zybank.parkinglot.model.Ticket;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {
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
    public void park_when_given_some_car() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        ParkingBoy boy = new ParkingBoy(parkingLotList);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 2);
        boy.parking(new Car());
        Assert.assertEquals(lot2.getAvailableParkingSpot(), 4);
        boy.parking(new Car());
        Assert.assertEquals(lot1.getAvailableParkingSpot(), 1);
    }

    @Test
    public void return_car_when_given_available_ticket() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        ParkingBoy boy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Ticket ticket = boy.parking(car);
        Car car2 = boy.getCar(ticket);
        Assert.assertEquals(car, car2);
    }

    @Test(expected = ParkingException.class)
    public void return_car_when_given_unavailable_ticket() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        ParkingBoy boy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Ticket ticket = boy.parking(car);
        Car car2 = boy.getCar(ticket);
        boy.getCar(ticket);
    }

    @Test
    public void return_car_when_given_available_ticket_twice() {
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(5);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(lot1);
        parkingLotList.add(lot2);

        ParkingBoy boy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        Car car2 = new Car();
        Ticket ticket1 = boy.parking(car);
        Ticket ticket2 = boy.parking(car2);
        Car reCar1 = boy.getCar(ticket1);
        Car reCar2 = boy.getCar(ticket2);
        Assert.assertEquals(car, reCar1);
        Assert.assertEquals(car2, reCar2);
    }
}
