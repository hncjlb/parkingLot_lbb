package com.zybank.parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingDirectorTest {
    @Test
    public void return_statement(){
        ParkingDirector director = new ParkingDirector();
        Assert.assertNotNull(director.getStatement());
    }
}
