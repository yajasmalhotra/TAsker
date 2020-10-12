package model;

// Assign tasks to teaching assistants
public class Task {

    private String name;
    private String time;
    private String teachingAssistant;
    private String course;
    private boolean status;


    public Task(String name) {
        this.name = name;
        this.status = false;
    }

    public void setTime(String newTime) {
        this.time = newTime;
    }

    public void setTeachingAssistant(String ta) {
        this.teachingAssistant = ta;
    }

    public void completeTask() {
        this.status = true;
    }
}
