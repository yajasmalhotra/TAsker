package persistence;

import model.Schedule;
import model.Task;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Schedule wr = new Schedule("Main");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Schedule schedule = new Schedule("Main");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            schedule = reader.read();
            assertEquals("Main", schedule.getName());
            assertEquals(2, schedule.getTasks().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Schedule schedule = new Schedule("Main");
            schedule.addTask(new Task("Task 1"));
            schedule.addTask(new Task("Task 2"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            schedule = reader.read();
            assertEquals("My work room", schedule.getName());
            List<Task> tasks = schedule.getTasks();
            assertEquals(2, schedule.getTasks().size());
            //checkTask("Task 1");
            //checkTask("Task 2");

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
