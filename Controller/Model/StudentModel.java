package assignment.Model;


import assignment.Entity.Student;

import java.sql.*;
import java.util.ArrayList;


/**
 * Làm nhiệm vụ thao tác với mảng student trong database.
 * Các thao tác gồm có: thêm mới một sinh viên, lấy danh sách sinh viên, xóa thông tin sinh viên.
 *
 * @author Đào Tùng
 */


public class StudentModel {
    public ArrayList<Student> getListStudent() {
        Connection connection = null;
        // khởi tạo một arraylist rỗng để chứa dữ liệu trả về từ My SQL.
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt", "root", "");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM  students");
            while (rs.next()) {
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                int gender = rs.getInt("gender");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int status = rs.getInt("status");
                long createdAt = rs.getLong("createdAt");
                long updateAt = rs.getLong("updateAt");

                // Tạo ra đối tượng student để hứng các dữ liệu lấy ra
                Student student = new Student(id, rollNumber, name, gender, phone, email, status, createdAt, updateAt);
                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.out.println("Can not connect to database.");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Can not close connection.");
            }
        }
        return listStudent;
    }

    public Student getByID(int id) {
        Student student = new Student();
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE id =" + id);
            while (rs.next()) {
                int studentID = rs.getInt("id");
                String studentRollNumber = rs.getString("rollNumber");
                String studentName = rs.getString("name");
                int studentGender = rs.getInt("gender");
                String studentPhone = rs.getString("phone");
                String studentEmail = rs.getString("email");
                int studentStatus = rs.getInt("status");
                long studentCreatedAt = rs.getLong("createdAt");
                long studentUpdateAt = rs.getLong("updateAt");
                student = new Student(studentID, studentRollNumber, studentName, studentGender, studentPhone, studentEmail, studentStatus, studentCreatedAt, studentUpdateAt);

            }
        } catch (SQLException ex) {
            System.out.println("Can not connect database.");

        }
        return student;
    }

    public Student getByRollNumber(String rollNumber) {
        Student student = new Student();
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE rollNumber =" + rollNumber);
            while (rs.next()) {
                int studentID = rs.getInt("id");
                String studentRollNumber = rs.getString("rollNumber");
                String studentName = rs.getString("name");
                int studentGender = rs.getInt("gender");
                String studentPhone = rs.getString("phone");
                String studentEmail = rs.getString("email");
                int studentStatus = rs.getInt("status");
                long studentCreatedAt = rs.getLong("createdAt");
                long studentUpdateAt = rs.getLong("updateAt");
                student = new Student(studentID, studentRollNumber, studentName, studentGender, studentPhone, studentEmail, studentStatus, studentCreatedAt, studentUpdateAt);

            }
        } catch (SQLException ex) {
            System.out.println("Can not connect database.");

        }
        return student;
    }

    public Student getByName(String name) {
        Student student = new Student();
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return null;
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE name =" + name);
            while (rs.next()) {
                int studentID = rs.getInt("id");
                String studentRollNumber = rs.getString("rollNumber");
                String studentName = rs.getString("name");
                int studentGender = rs.getInt("gender");
                String studentPhone = rs.getString("phone");
                String studentEmail = rs.getString("email");
                int studentStatus = rs.getInt("status");
                long studentCreatedAt = rs.getLong("createdAt");
                long studentUpdateAt = rs.getLong("updateAt");
                student = new Student(studentID, studentRollNumber, studentName, studentGender, studentPhone, studentEmail, studentStatus, studentCreatedAt, studentUpdateAt);

            }
        } catch (SQLException ex) {
            System.out.println("Can not connect database.");

        }
        return student;
    }

    public boolean update(Student existStudent) {
        Connection connection = ConnectionHelper.getConnection();
        if (connection == null) {
            return false;
        }
        try {
            String sqlUpdate = "UPDATE students SET  name = ?, gender = ?, phone = ?, email = ?, status = ?, updateAt = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, existStudent.getName());
            preparedStatement.setInt(2, existStudent.getGender());
            preparedStatement.setString(3, existStudent.getPhone());
            preparedStatement.setString(4, existStudent.getEmail());
            preparedStatement.setInt(5, existStudent.getStatus());
            preparedStatement.setLong(6, existStudent.getUpdateAt());
            preparedStatement.setInt(7, existStudent.getId());
            preparedStatement.executeUpdate();
            System.out.println("Update Success !!!");
        } catch (SQLException e) {
            System.err.println("Update fail !!!");
            e.printStackTrace();
        }
        return false;
    }
}
