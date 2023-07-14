package resep3.javat3.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DATABASE_URL = "jdbc:sqlite:WorkoutDB.db";
    private Connection connection;


    public void connect() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);

            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database");
            }
        } catch (SQLException e) {
            System.out.println("Failed to disconnect from the database");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
