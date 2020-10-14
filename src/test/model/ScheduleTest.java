package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    Schedule schedule;
    Task task1;
    Lab lab1;
    Tutorial tutorial1;

    @BeforeEach
    public void setup() {
        schedule = new Schedule("sc1");
        task1 = new Task("t1");
        lab1 = new Lab("l", 1, "l1");
        tutorial1 = new Tutorial("t", 1, "t1");
    }

    @Test
    public void testAddTaskNotAtLimit() {
        schedule.addTask(task1);

        assertEquals(1, schedule.getTasks().size());
    }

    @Test
    public void testAddTaskAtLimit() {
        for (int i = 0; i < 100; i++) {
            Task trialTask = new Task("trial");
            schedule.addTask(trialTask);
        }

        assertEquals(100, schedule.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        schedule.addTask(task1);
        schedule.removeTask(task1);

        assertEquals(0, schedule.getTasks().size());
    }

    @Test
    public void testGetTasks() {
        schedule.addTask(task1);
        ArrayList<Task> testList = new ArrayList<>();
        testList.add(task1);

        assertTrue(testList.equals(schedule.getTasks()));
    }

    @Test
    public void testAddLab() {
        schedule.addLab(lab1);

        assertEquals(1, schedule.getLabs().size());
    }

    @Test
    public void testRemoveLab() {
        schedule.addLab(lab1);
        schedule.removeLab(lab1);

        assertEquals(0, schedule.getLabs().size());
    }

    @Test
    public void testGetLabs() {
        schedule.addLab(lab1);
        ArrayList<Lab> testList = new ArrayList<>();
        testList.add(lab1);

        assertTrue(testList.equals(schedule.getLabs()));
    }

    @Test
    public void testAddTutorial() {
        schedule.addTutorial(tutorial1);

        assertEquals(1, schedule.getTutorials().size());
    }

    @Test
    public void testRemoveTutorial() {
        schedule.addTutorial(tutorial1);
        schedule.removeTutorial(tutorial1);

        assertEquals(0, schedule.getTutorials().size());
    }

    @Test
    public void testGetTutorials() {
        schedule.addTutorial(tutorial1);
        ArrayList<Tutorial> testList = new ArrayList<>();
        testList.add(tutorial1);

        assertTrue(testList.equals(schedule.getTutorials()));
    }
}