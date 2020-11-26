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

    public String getName() {
        return this.name;
    }

    public void assignTask(Task task) {
        if (!tasksAssigned.contains(task)) {
            tasksAssigned.add(task);
        }
    }

    public void removeFromTask(Task task) {
        tasksAssigned.remove(task);
        task.removeTeachingAssistant(this);
    }

}
