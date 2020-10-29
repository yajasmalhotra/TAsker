package persistence;

import model.Task;
import model.Tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected Task testTask;
    protected Tutorial testTutorial;

    protected void checkTutorial(String courseName, int courseNum, String sectionName) {
        assertEquals(courseName, testTutorial.getCourseName());
        assertEquals(courseNum, testTutorial.getCourseNum());
        assertEquals(sectionName, testTutorial.getSectionName());
    }

    protected void checkTask(String name) {
        assertEquals(name, testTask.getName());
    }

}
