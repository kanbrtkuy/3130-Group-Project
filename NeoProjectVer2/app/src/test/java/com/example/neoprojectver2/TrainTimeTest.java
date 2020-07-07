package com.example.neoprojectver2;

import org.junit.Test;

import static org.junit.Assert.*;


public class TrainTimeTest {
    // this is the unit test for get vaild user name
    @Test
    public void GetUsername() {
        TrainTime t1 = new TrainTime("amos", 8,40);
        assertEquals(t1.getUsername().equals("amos"),true);
    }

    // this is the unit test for get invaild user name
    @Test
    public void GetInvaildUsername() {
        TrainTime t1 = new TrainTime("amos", 8,40);
        assertNotEquals(t1.getUsername().equals("amo"),true);
    }

    // this is the unit test for get vaild start time

    @Test

    public void GetStarttime() {
        TrainTime t1 = new TrainTime("amos", 8,40);
        assertTrue(String.valueOf(true),t1.starttime(8,40));
    }

    // this is the unit test for get invaild start time

    @Test

    public void GetInvaildStarttime() {
        TrainTime t1 = new TrainTime("amos", 8,20);
        assertFalse(String.valueOf(false),t1.starttime(8,20));
    }



    @Test

    // this is the unit test for get vaild end time

    public void GetEndtime() {
        TrainTime t1 = new TrainTime("amos", 22,20);
        assertTrue(String.valueOf(true),t1.endtime(22,20));
    }

    // this is the unit test for get invaild end time

    @Test

    public void GetInvaildEndtime() {
        TrainTime t1 = new TrainTime("amos", 23,40);
        assertFalse(String.valueOf(false),t1.endtime(24,40));
    }

}
