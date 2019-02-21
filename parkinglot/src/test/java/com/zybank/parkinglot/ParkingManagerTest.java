package com.zybank.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingManagerTest extends ParkingBoyTest {
    @Test
    public void return_parking_boy_when_has_parking_boy() {
        ParkingBoy boy = new ParkingBoy(null);
        ParkingManager manager = new ParkingManager(null);
        manager.addParkingBoy(boy);
        Assert.assertEquals(manager.getParkingBoy(), boy);
    }

    @Test(expected = ParkingManagerException.class)
    public void throw_exception_when_add_null_boy() {
        ParkingBoy boy1 = null;
        ParkingManager manager = new ParkingManager(null);
        manager.addParkingBoy(boy1);
    }

    @Test(expected = ParkingManagerException.class)
    public void throw_exception_when_remove_first_boy() {
        ParkingBoy boy1 = new ParkingBoy(null);
        ParkingManager manager = new ParkingManager(null);
        manager.addParkingBoy(boy1);
        manager.removeParkingBoy(boy1);
        manager.getParkingBoy();
    }

    @Test
    public void return_second_parking_boy_when_remove_first_boy() {
        ParkingBoy boy1 = new ParkingBoy(null);
        ParkingBoy boy2 = new ParkingBoy(null);
        ParkingManager manager = new ParkingManager(null);
        manager.addParkingBoy(boy1);
        manager.addParkingBoy(boy2);
        manager.removeParkingBoy(boy1);
        Assert.assertEquals(manager.getParkingBoy(), boy2);
    }
}
