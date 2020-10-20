package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseEventTest {

    CourseEvent lab1;
    CourseEvent tutorial1;

    @BeforeEach
    public void setup() {
        lab1 = new Lab("lab", 1, "lab 1");
        tutorial1 = new Tutorial("tutorial", 1, "tutorial 1");

    }

    @Test
    public void testSetCourseName() {
        lab1.setCourseName("newCourseName");

        assertEquals("newCourseName", lab1.getCourseName());
    }

    @Test
    public void testSetCourseNum() {
        lab1.setCourseNum(2);

        assertEquals(2, lab1.getCourseNum());
    }

    @Test
    public void testSetSectionName() {
        lab1.setSectionName("newLabName");

        assertEquals("newLabName", lab1.getSectionName());
    }

    @Test
    public void testSetBuilding() {
        lab1.setBuilding("HENN");

        assertEquals("HENN", lab1.getBuilding());
    }

    @Test
    public void testSetRoomNumber() {
        lab1.setRoomNumber(0);

        assertEquals(0, lab1.getRoomNumber());
    }

    @Test
    public void testSetTime() {
        lab1.setTime("13:00");

        assertEquals("13:00", lab1.getTime());
    }

}