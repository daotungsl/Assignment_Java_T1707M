package assignment.Main;

import assignment.Controller.StudentController;
import assignment.Entity.Student;
import assignment.Model.StudentModel;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    StudentModel model = new StudentModel();
    StudentController studentController = new StudentController();
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {

        while (true) {
            int choie = 0;
            System.out.println("===============Student Manager===============");
            System.out.println(" \t 1. Student list.");
            System.out.println(" \t 2. Student information.");
            System.out.println(" \t 3. Insert Student.");
            System.out.println(" \t 4. Edit Student.");
            System.out.println(" \t 5. Delete Student.");
            System.out.println(" \t 6. Exit.");
            System.out.println("=============================================");
            System.out.println("Please enter your choice: ");
            choie = scanner.nextInt();
            switch (choie) {
                case 1:
                    studentList();
                    break;
                case 2:
                    studentInfo();
                    break;
                case 3:
                    insertStudent();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Please enter choice from 1 to 6.");
                    break;
            }
        }
    }

    public void studentList() {
        ArrayList<Student> list = model.getListStudent();
        System.out.println("===============Student List===============");
        System.out.println("Id \t \t Name");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + " - " + student.getName());
        }
        System.out.println("==========================================");
    }

    public void studentInfo() {
        System.out.println("===============Student Info===============");
        System.out.println("Enter Id student: ");
        int id = scanner.nextInt();
        studentController.getInfoStudent(id);
    }

    public void insertStudent() {
        studentController.getAddStudent();
    }

    public void editStudent() {
        System.out.println("===============Edit Student===============");
        System.out.println("Enter id edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        studentController.getUpdateStudent(id);


    }

    public void deleteStudent() {
        System.out.println("===============Delete Student===============");
        System.out.println("Enter ID you want Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        studentController.getDeleteStudent(id);
    }
}
