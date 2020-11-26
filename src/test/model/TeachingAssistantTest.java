package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeachingAssistantTest {
    private TeachingAssistant ta1;
    private Task task1;

    @BeforeEach
    public void runBefore() {
        ta1 = new TeachingAssistant("test name");
        task1 = new Task("Task 1");
    }

    @Test
    public void testSetName() {
        ta1.setName("new name");
        assertTrue(ta1.getName().equals("new name"));
    }

    @Test
    public void testRemoveFromTask() {
        task1.addTeachingAssistant(ta1);
        ta1.removeFromTask(task1);

        assertNull(task1.getTeachingAssistants());
    }

}
