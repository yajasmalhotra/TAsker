package persistence;

import model.Schedule;
import model.Task;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Schedule schedule = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWSchedule() {
        JsonReader reader = new JsonReader("./data/TestReaderEmptySchedule.json");
        try {
            Schedule schedule = reader.read();
            assertEquals("Main", schedule.getName());
            assertEquals(0, schedule.getTasks().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSchedule() {
        JsonReader reader = new JsonReader("./data/TestReaderGeneralSchedule.json");
        try {
            Schedule schedule = reader.read();
            assertEquals("Main", schedule.getName());
            List<Task> tasks = schedule.getTasks();
            assertEquals(2, tasks.size());
            checkTask("Task 1");

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}