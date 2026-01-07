import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    int id;
    String name;
    int age;

    // constructor
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

// Main class
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // CREATE
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    // READ
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Age: " + s.age);
        }
    }

    // UPDATE
    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new age: ");
                s.age = sc.nextInt();

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // DELETE
    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
