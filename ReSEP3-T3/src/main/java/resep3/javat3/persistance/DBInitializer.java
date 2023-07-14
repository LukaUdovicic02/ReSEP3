package resep3.javat3.persistance;

import java.sql.*;

public class DBInitializer {

    public static void main(String[] args) {
      //  insertLoginData( "John", "password123" , 70 , 15);
      //  updateData(2, "Johnny" , "123");
        deleteData(6);
    }

    private static void insertLoginData( String username, String password , float bodyWeight , float fatPercentage ) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {


            String insertQuery = "INSERT INTO User (username, password,bodyWeight , fatPercentage )" +
                    " VALUES ( '" + username + "', '" + password + "','" + bodyWeight + "' , '" + fatPercentage + "' )";

            statement.executeUpdate(insertQuery);
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to insert data.");
            e.printStackTrace();
        }
    }

    // works
    private static void updateData(int uid,String username, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {
            String updateQuery = "UPDATE User SET username = '" + username + "', password = '" + password + "' WHERE UID = " + uid;
            statement.executeUpdate(updateQuery);
            System.out.println("Data updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update data.");
            e.printStackTrace();
        }
    }


    private static void deleteData(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {
                String deleteQuery = "DELETE FROM User WHERE UID = " + id;
            statement.executeUpdate(deleteQuery);
            System.out.println("Data deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete data.");
            e.printStackTrace();
        }
    }
}
