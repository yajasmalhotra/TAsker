package model;

public class Tutorial {

    private String courseName;
    private int courseNum;
    private String tutorialName;
    private String building;
    private int roomNumber;
    private String time;

    public Tutorial(String courseName, int courseNum, String tutorialName) {
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.tutorialName = tutorialName;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }

    public void setCourseNum(int newNum) {
        this.courseNum = newNum;
    }

    public void setTutorialName(String newTutorialName) {
        this.tutorialName = newTutorialName;
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

    public String getTutorialName() {
        return tutorialName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseName() {
        return courseName;
    }
}

