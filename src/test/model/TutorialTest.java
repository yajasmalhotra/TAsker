package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TutorialTest {

    Tutorial tutorial1;

    @BeforeEach
    public void setup() {
        tutorial1 = new Tutorial("tutorial", 1, "tutorial 1");

    }

    @Test
    public void testSetCourseName() {
        tutorial1.setCourseName("newCourseName");

        assertEquals("newCourseName", tutorial1.getCourseName());
    }

    @Test
    public void testSetCourseNum() {
        tutorial1.setCourseNum(2);

        assertEquals(2, tutorial1.getCourseNum());
    }

    @Test
    public void testSetLabName() {
        tutorial1.setTutorialName("newLabName");

        assertEquals("newLabName", tutorial1.getTutorialName());
    }

    @Test
    public void testSetBuilding() {
        tutorial1.setBuilding("HENN");

        assertEquals("HENN", tutorial1.getBuilding());
    }

    @Test
    public void testSetRoomNumber() {
        tutorial1.setRoomNumber(0);

        assertEquals(0, tutorial1.getRoomNumber());
    }

    @Test
    public void testSetTime() {
        tutorial1.setTime("13:00");

        assertEquals("13:00", tutorial1.getTime());
    }
}
