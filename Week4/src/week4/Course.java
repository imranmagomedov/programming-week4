
package week4;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private int capacity;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    public boolean isStudentRegistered(String studentID) {
        for (Student student : enrolledStudents) {
            if (student.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled Students: "
                + enrolledStudents.size());

        System.out.println("Student List:");

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println(
                        student.getStudentID() + " - "
                        + student.getName());
            }
        }
    }
}
