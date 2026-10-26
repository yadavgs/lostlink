import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Update your database URL, username, and password if different
    private static final String URL = "jdbc:mysql://localhost:3306/lostlink_db";
    private static final String USER = "root";       // Your MySQL username
    private static final String PASSWORD = "2007"; // Your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check your username/password or if MySQL is running.");
            e.printStackTrace();
        }
        return conn;
    }

    // Quick test main method
    public static void main(String[] args) {
        getConnection();
    }
}
