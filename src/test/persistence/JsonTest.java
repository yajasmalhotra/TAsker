package persistence;

import model.Tutorial;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {

    protected Tutorial test;



    protected void checkTutorial(String courseName, int courseNum, String sectionName) {
        assertEquals(courseName, test.getCourseName());
        assertEquals(courseNum, test.getCourseNum());
        assertEquals(sectionName, test.getSectionName());
    }

}
