package model;

import persistence.Writable;

// Modify labs and related information
public class Lab extends CourseEvent implements Writable {

    public Lab(String courseName, int courseNum, String sectionName) {
        super(courseName, courseNum, sectionName);
    }

}

