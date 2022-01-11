package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
        public static Connection createConnection()
        {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/application"; // MySQL URL and followed by the Database name
            String username = "root"; // MySQL username
            String password = "123456"; // MySQL password
            try
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // Loading MySQL driver
                }
                catch (ClassNotFoundException exception)
                {
                    exception.printStackTrace();
                }
                connection = DriverManager.getConnection(url, username, password); // Attempting to connect to MySQL Database
                System.out.println("Database Connection Established");
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return connection;
        }
}
