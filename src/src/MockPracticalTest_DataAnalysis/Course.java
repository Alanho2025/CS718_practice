package MockPracticalTest_DataAnalysis;

import java.util.ArrayList;

public class Course {
    String courseName;
    String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return courseCode + " : "+ courseName;
    }
}
