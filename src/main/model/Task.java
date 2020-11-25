package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Assign tasks to teaching assistants
public class Task implements Writable {

    private String name;
    private String time;
    private String teachingAssistant;
    private List<TeachingAssistant> teachingAssistantList;
    private String course;
    private boolean status;

    public Task(String name) {
        this.name = name;
        this.status = false;
        this.teachingAssistant = null;
        this.course = null;
        this.time = null;
        teachingAssistantList = new ArrayList<>();
    }

    public void setTime(String newTime) {
        this.time = newTime;
    }

    public void addTeachingAssistant(TeachingAssistant ta) {
        teachingAssistantList.add(ta);
        ta.assignTask(this);
    }

    // REQUIRES: this.status must already be false
    // MODIFIES: this
    // EFFECTS: this.status is made true
    public void completeTask() {
        this.status = true;
    }

    // REQUIRES: this.status must already be true
    // MODIFIES: this
    // EFFECTS: this.status is made false
    public void undoTask() {
        this.status = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        String error = "Not Assigned";

        if (time == null) {
            return error;
        } else {
            return time;
        }
    }

    public List<TeachingAssistant> getTeachingAssistant() {
        String error = "Not Assigned";

        if (teachingAssistantList.isEmpty()) {
            return null;
        } else {
            return teachingAssistantList;
        }
    }

    public String getCourse() {
        String error = "Not Assigned";

        if (course == null) {
            return error;
        } else {
            return course;
        }
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("time", time);
        json.put("teachingAssistant", teachingAssistant);
        json.put("course", course);
        json.put("status", status);

        return json;
    }
}
