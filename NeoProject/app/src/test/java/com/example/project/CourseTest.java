package com.example.project;

import org.junit.Test;

import static org.junit.Assert.*;


public class CourseTest {
    @Test
    public void GetTeacherName(){
        Course c1 = new Course("ShortRun","Bob","A",1,1,2);
        assertEquals("Bob",c1.getTeacher());
        assertNotEquals("Amos",c1.getTeacher());
    }

    @Test
    public void GetClassRomm(){
        Course c1 = new Course("ShortRun","Bob","A",1,1,2);
        assertEquals("A",c1.getClassRoom());
        assertNotEquals("B",c1.getClassRoom());
    }

    @Test
    public void GetStartTime(){
        Course c1 = new Course("ShortRun","Bob","A",1,1,2);
        assertTrue("1",c1.getStart()==1);
        assertFalse("1",c1.getStart() == 3);
    }

    @Test
    public void GetEndTime(){
        Course c1 = new Course("ShortRun","Bob","A",1,1,2);
        assertTrue("2",c1.getEnd()==2);
        assertFalse("2",c1.getEnd() == 4);
    }
}
