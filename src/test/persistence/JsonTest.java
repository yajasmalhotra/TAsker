package persistence;

import model.Task;
import model.Tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    public Task testTask;
    public Tutorial testTutorial;

    protected void checkTutorial(String courseName, int courseNum, String sectionName, Tutorial tutorial) {
        assertEquals(courseName, tutorial.getCourseName());
        assertEquals(courseNum, tutorial.getCourseNum());
        assertEquals(sectionName, tutorial.getSectionName());
    }

    protected void checkTask(String name, Task task) {
        assertEquals(name, task.getName());
    }

}
