
package week4;
import java.util.ArrayList;
import java.util.Scanner;

public class Week4 {

   
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        // Course Setup
        int numberOfCourses;

        do {
            System.out.print("How many courses do you want to create? (At least 3): ");
            numberOfCourses = input.nextInt();
            input.nextLine();

            if (numberOfCourses < 3) {
                System.out.println("You must create at least 3 courses.");
            }

        } while (numberOfCourses < 3);

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.println("\nCourse " + (i + 1));

            System.out.print("Enter course name: ");
            String courseName = input.nextLine();

            System.out.print("Enter classroom capacity: ");
            int capacity = input.nextInt();
            input.nextLine();

            while (capacity <= 0) {
                System.out.print("Capacity must be positive. Enter again: ");
                capacity = input.nextInt();
                input.nextLine();
            }

            Course course = new Course(courseName, capacity);
            courses.add(course);
        }

        System.out.println("\nAll courses created successfully!");

        // Main Menu
        int choice;

        do {
            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    // Get student information
                    System.out.print("Enter student ID: ");
                    String studentID = input.nextLine();

                    System.out.print("Enter student name: ");
                    String studentName = input.nextLine();

                    System.out.print("Enter course name to register: ");
                    String requestedCourse = input.nextLine();

                    // Find course by name
                    Course selectedCourse = null;

                    for (Course course : courses) {
                        if (course.getCourseName().equalsIgnoreCase(
                                requestedCourse.trim())) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse == null) {
                        System.out.println(
                                "No course found with that name.");
                    } else if (selectedCourse.isFull()) {
                        System.out.println(
                                "This course has reached its capacity.");
                    } else if (selectedCourse.isStudentRegistered(
                            studentID)) {
                        System.out.println(
                                "This student is already registered "
                                + "for this course.");
                    } else {
                        Student student = new Student(
                                studentID, studentName);

                        selectedCourse.addStudent(student);

                        System.out.println(
                                "Registration successful!");
                    }
                    break;

                case 2:
                    // View All Courses
                    System.out.println("\n===== ALL COURSES =====");

                    for (Course course : courses) {
                        course.displayCourseInfo();
                    }
                    break;

                case 3:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please try again.");
            }

        } while (choice != 3);

        input.close();
    }
}

        
        
        
        
        
        
        
    
    

