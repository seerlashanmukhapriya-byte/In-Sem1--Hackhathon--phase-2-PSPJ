import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Course fee is Rs. 1500 per credit
    double calculateFee() {
        return courseCredits * 1500.0;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    // Returns the scholarship percentage
    double calculateScholarship() {
        if (marks >= 85) {
            return 20;
        } else if (marks >= 70) {
            return 10;
        }
        return 0;
    }

    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarshipAmount = fee * calculateScholarship() / 100;
        return fee - scholarshipAmount;
    }

    void displayDetails() {
        double fee = calculateFee();
        double scholarshipPercentage = calculateScholarship();
        double scholarshipAmount = fee * scholarshipPercentage / 100;

        System.out.println("\n--- Student Course Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: Eligible");
        System.out.printf("Course Fee: Rs. %.2f%n", fee);
        System.out.printf("Scholarship: %.0f%% (Rs. %.2f)%n",
                scholarshipPercentage, scholarshipAmount);
        System.out.printf("Final Fee: Rs. %.2f%n", calculateFinalFee());
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int credits = scanner.nextInt();

        Student student = new Student(name, rollNumber, marks, courseName, credits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for course registration.");
        }

        scanner.close();
    }
}