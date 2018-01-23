package assignment.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            //Tạo két nối với tài khoản root, password rỗng.
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt", "root", "");
            } catch (SQLException e) {
                System.out.println("Can not connect database.");
                e.printStackTrace();
                connection = null;
            }
        }

        return connection;
    }


}
