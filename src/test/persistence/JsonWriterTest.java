package persistence;

import model.Lab;
import model.Schedule;
import model.Task;
import model.Tutorial;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Schedule schedule = new Schedule("Main");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySchedule() {
        try {
            Schedule schedule = new Schedule("Main");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySchedule.json");
            writer.open();
            writer.write(schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySchedule.json");
            schedule = reader.read();
            assertEquals("Main", schedule.getName());
            assertEquals(0, schedule.getTasks().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSchedule() {
        try {
            Schedule schedule = new Schedule("Main");
            schedule.addTask(new Task("Task 1"));
            schedule.addTask(new Task("Task 2"));
            schedule.addTutorial(new Tutorial("Tutorial 1", 0, "Test"));
            schedule.addLab(new Lab("Lab 1", 0, "Test"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSchedule.json");
            writer.open();
            writer.write(schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSchedule.json");
            schedule = reader.read();
            assertEquals("Main", schedule.getName());
            List<Task> tasks = schedule.getTasks();
            List<Tutorial> tutorials = schedule.getTutorials();
            List<Lab> labs = schedule.getLabs();
            assertEquals(2, schedule.getTasks().size());
            assertEquals(1, schedule.getTutorials().size());
            assertEquals(1, schedule.getLabs().size());
            checkTask("Task 1", tasks.get(0));
            checkTask("Task 2", tasks.get(1));
            checkTutorial("Lab 1", 0, "Test", tutorials.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
