package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    Task task1;

    @BeforeEach
    public void setup() {
        task1 = new Task("Task Test");
    }

    @Test
    public void testSetTime() {
        task1.setTime("13:00");

        assertEquals("13:00", task1.getTime());
    }

    @Test
    public void testSetTeachingAssistant() {
        task1.setTeachingAssistant("Andrew");

        assertEquals("Andrew", task1.getTeachingAssistant());
    }

    @Test
    public void testCompleteTask() {
        task1.completeTask();

        assertTrue(task1.getStatus());
    }

    @Test
    public void testUndoTask() {
        task1.completeTask();
        task1.undoTask();

        assertFalse(task1.getStatus());
    }

    @Test
    public void testSetName() {
        task1.setName("New Name");

        assertEquals("New Name", task1.getName());
    }

    @Test
    public void testSetCourse() {
        task1.setCourse("Course 1");

        assertEquals("Course 1", task1.getCourse());
    }


}
