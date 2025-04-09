package MockPracticalTest_DataAnalysis;

public class StudentRecord {
    String sudentID;
    Course course;
    Grade grade;

    public StudentRecord(String sudentID, Course course, Grade grade) {
        this.sudentID = sudentID;
        this.course = course;
        this.grade = grade;
    }
    public String getSudentID() {
        return sudentID;
    }
    public Course getCourse() {
        return course;
    }
    public Grade getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return this.sudentID + " take " + this.grade.toString() + " in the " + this.course.toString();
    }
}
