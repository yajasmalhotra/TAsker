package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseEventTest {

    CourseEvent lab1;
    CourseEvent tutorial1;
    String error;

    @BeforeEach
    public void setup() {
        lab1 = new Lab("lab", 1, "lab 1");
        tutorial1 = new Tutorial("tutorial", 1, "tutorial 1");
        error = "Not Assigned";
    }

    @Test
    public void testSetCourseNameNoError() {
        lab1.setCourseName("newCourseName");
        tutorial1.setCourseName("newCourseName");

        assertEquals("newCourseName", lab1.getCourseName());
        assertEquals("newCourseName", tutorial1.getCourseName());

    }

    @Test
    public void testSetCourseNameError() {
        lab1.setCourseName(null);
        tutorial1.setCourseName(null);

        assertEquals(error, lab1.getCourseName(), tutorial1.getCourseName());
    }

    @Test
    public void testSetCourseNum() {
        lab1.setCourseNum(2);
        tutorial1.setCourseNum(4);

        assertEquals(2, lab1.getCourseNum());
        assertEquals(4, tutorial1.getCourseNum());
    }

    @Test
    public void testSetSectionNameNoError() {
        lab1.setSectionName("newLabName");
        tutorial1.setSectionName("newTutorialName");

        assertEquals("newLabName", lab1.getSectionName());
        assertEquals("newTutorialName", tutorial1.getSectionName());

    }

    @Test
    public void testSetSectionNameError() {
        lab1.setSectionName(null);
        tutorial1.setSectionName(null);
        assertEquals(error, lab1.getSectionName(), tutorial1.getSectionName());
    }

    @Test
    public void testSetBuildingNoError() {
        lab1.setBuilding("HENN");
        tutorial1.setBuilding("ICCS");

        assertEquals("HENN", lab1.getBuilding());
        assertEquals("ICCS", tutorial1.getBuilding());
    }

    @Test
    public void testSetBuildingError() {
        assertEquals(error, lab1.getBuilding(), tutorial1.getBuilding());
    }

    @Test
    public void testSetRoomNumber() {
        lab1.setRoomNumber(0);
        tutorial1.setRoomNumber(10);

        assertEquals(0, lab1.getRoomNumber());
        assertEquals(10, tutorial1.getRoomNumber());
    }

    @Test
    public void testSetTimeNoError() {
        lab1.setTime("13:00");
        tutorial1.setTime("15:30");

        assertEquals("13:00", lab1.getTime());
        assertEquals("15:30", tutorial1.getTime());
    }

    @Test
    public void testSetTimeError() {
        assertEquals(error, lab1.getTime(), tutorial1.getTime());
    }

}
