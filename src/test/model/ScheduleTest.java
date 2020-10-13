package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testAddTask() {
        schedule.addTask(task1);

        assertEquals(1, schedule.getTasks().size());
    }

    @Test
    public void testRemoveTask() {

    }

    @Test
    public void testGetTasks() {

    }

    @Test
    public void testAddLab() {

    }

    @Test
    public void testRemoveLab() {

    }

    @Test
    public void testGetLabs() {

    }

    @Test
    public void testAddTutorial() {

    }

    @Test
    public void testRemoveTutorial() {

    }

    @Test
    public void testGetTutorials() {

    }
}