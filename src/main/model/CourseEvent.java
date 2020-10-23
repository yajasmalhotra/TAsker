package model;

import org.json.JSONObject;
import persistence.Writable;

public abstract class CourseEvent implements Writable {

    private String courseName;
    private int courseNum;
    private String sectionName;
    private String building;
    private int roomNumber;
    private String time;

    public CourseEvent(String courseName, int courseNum, String sectionName) {
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.sectionName = sectionName;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }

    public void setCourseNum(int newNum) {
        this.courseNum = newNum;
    }

    public void setSectionName(String newSectionName) {
        this.sectionName = newSectionName;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        String error = "Not Assigned";

        if (time == null) {
            return error;
        } else {
            return time;
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBuilding() {
        String error = "Not Assigned";

        if (building == null) {
            return error;
        } else {
            return building;
        }
    }

    public String getSectionName() {
        String error = "Not Assigned";

        if (sectionName == null) {
            return error;
        } else {
            return sectionName;
        }
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        String error = "Not Assigned";

        if (courseName == null) {
            return error;
        } else {
            return courseName;
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("courseName", courseName);
        json.put("courseNum", courseNum);
        json.put("sectionName", sectionName);
        json.put("building", building);
        json.put("roomNumber", roomNumber);
        json.put("time", time);

        return json;
    }
}
