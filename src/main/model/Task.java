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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public String getTeachingAssistant() {
        return teachingAssistant;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
