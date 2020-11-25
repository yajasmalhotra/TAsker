package model;

import java.util.ArrayList;
import java.util.List;

public class TeachingAssistant {
    private String name;
    private List<Task> tasksAssigned;

    public TeachingAssistant(String name) {
        this.name = name;
        tasksAssigned = new ArrayList<>();
    }

    public void setName(String newName) {
        name = newName;
    }

    public void assignTask(Task task) {
        if (!tasksAssigned.contains(task)) {
            tasksAssigned.add(task);
        }

    }

}
