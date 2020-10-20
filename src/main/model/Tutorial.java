package model;

import persistence.Writable;

// Modify tutorials and related information
public class Tutorial extends CourseEvent implements Writable {

    public Tutorial(String courseName, int courseNum, String sectionName) {
        super(courseName, courseNum, sectionName);
    }

}

