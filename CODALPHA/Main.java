import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            students.add(new Student(name, grade));
        }

        // Calculate stats
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String highestScorer = "", lowestScorer = "";

        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                highestScorer = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowestScorer = s.name;
            }
        }

        double average = total / numStudents;

        // Summary Report
        System.out.println("\n--- Student Grades Summary ---");
        for (Student s : students) {
            System.out.println("Student: " + s.name + " | Grade: " + s.grade);
        }

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (by " + highestScorer + ")");
        System.out.println("Lowest Grade: " + lowest + " (by " + lowestScorer + ")");

        scanner.close();
    }
}
