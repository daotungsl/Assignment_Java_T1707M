package assignment.Controller;

import assignment.Entity.Student;

import java.util.Scanner;

public class CheckEnter {
    Scanner scanner = new Scanner(System.in);
    Student student = new Student();
    public void checkEnterRollNumber() {
        while (true) {
            System.out.println("Please enter student roll number: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 0) {
                student.setRollNumber(value);
                break;
            }
            System.out.println("Rollnumber's required.");
        }
    }

    public void checkEnterName() {
        while (true) {
            System.out.println("Please enter student name: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 5) {
                student.setName(value);
                break;
            }
            System.out.println("Name's required.");
        }
    }

    public void checkEnterGender() {
        while (true) {
            System.out.println("Please enter student gender: ");
            System.out.println("Female = 0");
            System.out.println("Male = 1");
            System.out.println("Other = 2");
            int value = scanner.nextInt();scanner.nextLine();
            if (-1 < value && value < 3) {
                student.setGender(value);
                break;
            }
            System.out.println("Gender's required.");
        }
    }

    public void checkEnterPhone() {
        while (true) {
            System.out.println("Please enter student phone: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 9) {
                student.setPhone(value);
                break;
            }
            System.out.println("Phone's required.");
        }
    }

    public void checkEnterEmail() {
        while (true) {
            System.out.println("Please enter student email: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 5) {
                student.setEmail(value);
                break;
            }
            System.out.println("Email's required.");
        }
    }

    public void checkEnterStatus() {
        while (true) {
            System.out.println("Please enter student status: ");
            int value = scanner.nextInt();scanner.nextLine();
            if (-1 < value && value < 2) {
                student.setStatus(value);
                break;
            }
            System.out.println("Status's just 0 or 1.");
        }
    }
}
