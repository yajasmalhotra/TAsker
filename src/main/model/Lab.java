package model;

// Modify labs and related information
public class Lab {

    private String courseName;
    private int courseNum;
    private String labName;
    private String building;
    private int roomNumber;
    private String time;

    public Lab(String courseName, int courseNum, String labName) {
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.labName = labName;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }

    public void setCourseNum(int newNum) {
        this.courseNum = newNum;
    }

    public void setLabName(String newLabName) {
        this.labName = newLabName;
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
        return time;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public String getLabName() {
        return labName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        return courseName;
    }
}

