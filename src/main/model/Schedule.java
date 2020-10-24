package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Schedule implements Writable {

    private static ArrayList<Task> tasks;
    private static ArrayList<Lab> labs;
    private static ArrayList<Tutorial> tutorials;
    private final String name;

    public Schedule(String name) {
        this.name = name;
        tasks = new ArrayList<>();
        labs = new ArrayList<>();
        tutorials = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (tasks.size() < 100) {           // added task limit of 100 to add branching
            tasks.add(task);
        }
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

    public ArrayList<Lab> getLabs() {
        return labs;
    }

    public void addTutorial(Tutorial tutorial) {
        tutorials.add(tutorial);
    }

    public void removeTutorial(Tutorial tutorial) {
        tutorials.remove(tutorial);
    }

    public ArrayList<Tutorial> getTutorials() {
        return tutorials;
    }

    @Override
    public JSONObject toJson() {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("tasks", tasksToJson());
        json.put("labs", labsToJson());
        json.put("tutorials", tutorialToJson());
        return json;
    }

    private JSONArray tasksToJson() {
        JSONArray taskJsonArray = new JSONArray();

        for (Task task : tasks) {
            taskJsonArray.put(task.toJson());
        }
        return taskJsonArray;
    }

    private JSONArray labsToJson() {
        JSONArray labJsonArray = new JSONArray();

        for (Lab lab : labs) {
            labJsonArray.put(lab.toJson());
        }
        return labJsonArray;
    }

    private JSONArray tutorialToJson() {
        JSONArray tutorialJsonArray = new JSONArray();

        for (Tutorial tutorial : tutorials) {
            tutorialJsonArray.put(tutorial.toJson());
        }
        return tutorialJsonArray;
    }



}
