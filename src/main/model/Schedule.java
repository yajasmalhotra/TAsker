package model;

import java.util.ArrayList;

public class Schedule {

    private static ArrayList<Task> tasks;
    private static ArrayList<Lab> labs;
    private static ArrayList<Tutorial> tutorials;

    public Schedule() {
        tasks = new ArrayList<Task>();
        labs = new ArrayList<Lab>();
        tutorials = new ArrayList<Tutorial>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addLab(Lab lab) {
        labs.add(lab);
    }

    public void removeLab(Lab lab) {
        labs.remove(lab);
    }

    public void addTutorial(Tutorial tutorial) {
        tutorials.add(tutorial);
    }

    public void removeTutorial(Tutorial tutorial) {
        tutorials.remove(tutorial);
    }


}
