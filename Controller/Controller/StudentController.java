package assignment.Controller;

import assignment.Entity.Student;
import assignment.Model.ConnectionHelper;
import assignment.Model.StudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StudentController {
    private StudentModel model = new StudentModel();

    Scanner scanner = new Scanner(System.in);


    public void getAddStudent() {
        Student student = new Student();
        while (true) {
            System.out.println("Please enter student roll number: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 0) {
                student.setRollNumber(value);
                break;
            }
            System.out.println("Rollnumber's required.");
        }
        while (true) {
            System.out.println("Please enter student name: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 5) {
                student.setName(value);
                break;
            }
            System.out.println("Name's required.");
        }
        while (true) {
            System.out.println("Please enter student gender: ");
            System.out.println("Female = 0");
            System.out.println("Male = 1");
            System.out.println("Other = 2");
            int value = scanner.nextInt();
            scanner.nextLine();
            if (-1 < value && value < 3) {
                student.setGender(value);
                break;
            }
            System.out.println("Gender's required.");
        }
        while (true) {
            System.out.println("Please enter student phone: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 9) {
                student.setPhone(value);
                break;
            }
            System.out.println("Phone's required.");
        }
        while (true) {
            System.out.println("Please enter student email: ");
            String value = scanner.nextLine();
            if (value != null && value.length() > 5) {
                student.setEmail(value);
                break;
            }
            System.out.println("Email's required.");
        }

        long createdAt = new Long(System.currentTimeMillis());
        student.setCreatedAt(createdAt);
        insert(student);

    }
//    public void getAddStudent1() {
//        CheckEnter check = new CheckEnter();
//        Student student = Student() ;
//        check.checkEnterRollNumber();
//        check.checkEnterName();
//        check.checkEnterGender();
//        check.checkEnterPhone();
//        check.checkEnterEmail();
//        Long createdAt = new Long(System.currentTimeMillis());
//        student.setCreatedAt(createdAt);
//        insert(student);
//
//    }


    //    public void getUpdateStudent(int id) {
//        Student student = model.getByID(id);
//        if (student.getId() == 0) {
//            System.out.println("Student does not exist !!!");
//        } else {
//            System.out.println("==========Student Detail==========");
//            getInfoStudent(id);
//            System.out.println("==================================");
//            check.checkEnterName();
//            check.checkEnterGender();
//            check.checkEnterPhone();
//            check.checkEnterEmail();
//            check.checkEnterStatus();
//            Long updateAt = new Long(System.currentTimeMillis());
//            student.setUpdateAt(updateAt);
//            model.update(student);
//
//        }
//    }
    public void getUpdateStudent(int id) {
        Student existStudent = model.getByID(id);
        if (existStudent.getId() == 0) {
            System.out.println("Student does not exist !!!");
        } else {
            System.out.println("==========Student Detail==========");
            getInfoStudentId(id);
            System.out.println("==================================");
            System.out.println("Enter new name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new gender: ");
            System.out.println("Female = 0");
            System.out.println("Male = 1");
            System.out.println("Other = 2");
            int gender = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new phone: ");
            String phone = scanner.nextLine();
            System.out.println("Enter new email: ");
            String email = scanner.nextLine();
            System.out.println("Enter new status: ");
            int status = scanner.nextInt();
            long updateAt = new Long(System.currentTimeMillis());
            existStudent.setName(name);
            existStudent.setGender(gender);
            existStudent.setPhone(phone);
            existStudent.setEmail(email);
            existStudent.setStatus(status);
            existStudent.setUpdateAt(updateAt);
            model.update(existStudent);

        }
    }

    public void getDeleteStudent(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            getInfoStudentId(id);
            System.out.println("You want delete ID =" + id);
            System.out.println("Enter Y/N ?");
            String choiceDelete = scanner.nextLine();
            String choiceYes = "y";
            if (choiceDelete.equalsIgnoreCase(choiceYes) == true) {
                String sqlDelete = "DELETE FROM students WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(sqlDelete);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("DELETE SUCCESS.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DELETE ERROR !!!");
        }

    }

    public void getInfoStudentId(int idInfo) {
        Student exitStudent = model.getByID(idInfo);
        showInfoStudent(exitStudent);
    }
    public void getInfoStudentRollNumber(String rollNumber) {
        Student exitStudent = model.getByRollNumber(rollNumber);
        showInfoStudent(exitStudent);
    }
    public void getInfoStudentName(String name) {
        Student exitStudent = model.getByName(name);
        showInfoStudent(exitStudent);
    }
    public void showInfoStudent(Student exitStudent){
    SimpleDateFormat timeFomat = new SimpleDateFormat("hh:mm:ss a dd/MM/yyyy Z");
    String timeCreated = timeFomat.format(exitStudent.getCreatedAt());
    String timeUpdate = timeFomat.format(exitStudent.getUpdateAt());
        if (exitStudent.getId() == 0) {
            System.out.println("Student is not exist or has been deleted !!!. ");
        } else {
            System.out.println("- ID Number:      " + exitStudent.getId());
            System.out.println("- Roll Number:    " + exitStudent.getRollNumber());
            System.out.println("- Name Student:   " + exitStudent.getName());
            System.out.println("- Gender Student: " + (exitStudent.getGender() == 1 ? "Male" : (exitStudent.getGender() == 0 ? "Female:" : "Other")));
            System.out.println("- Phone Student:  " + exitStudent.getPhone());
            System.out.println("- Email Student:  " + exitStudent.getEmail());
            System.out.println("- Created At:     " + timeCreated + " GMT");
            System.out.println("- Status Student: " + exitStudent.getStatus());

            if (exitStudent.getUpdateAt() == 0) {
                System.out.println("- Update At:      " + "Never Update");
            } else {
                System.out.println("- Update At:      " + timeUpdate + " GMT");
            }
        }
    }


    public boolean insert(Student student) {
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }

        try {
            String sqlInsert = "INSERT Into students (rollNumber, name, gender, phone, email, createdAt, updateAt)VALUE (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, student.getRollNumber());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getGender());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.setLong(6, student.getCreatedAt());
            ps.setLong(7, student.getUpdateAt());
            ps.execute();
            System.out.println("INSERT SUCCESS");
        } catch (SQLException e) {
            System.out.println("INSERT ERROR");
            e.printStackTrace();
        }

        return false;
    }

    public void getInfoId(){
        System.out.println("Enter Id student: ");
        int id = scanner.nextInt();
        getInfoStudentId(id);

    }
    public void getInfoRollNumber(){
        System.out.println("Enter Roll Number student: ");
        String rollNumber = scanner.nextLine();
        getInfoStudentRollNumber(rollNumber);

    }
    public void getInfoName(){
        System.out.println("Enter Name student: ");
        String name = scanner.nextLine();
        getInfoStudentName(name);
    }

}
