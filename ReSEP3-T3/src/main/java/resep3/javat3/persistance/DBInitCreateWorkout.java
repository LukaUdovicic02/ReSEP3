package resep3.javat3.persistance;

import java.sql.*;

public class DBInitCreateWorkout {

    public static void main(String[] args) {

      //  insertWorkoutPlan("chestworkout" , 2 , "chest" , 1);
      // updateWorkout(2 , "legworkout" , 30 , "leg");
     //   deleteWorkout(2);
    }


    private static void insertWorkoutPlan(String WPname, int timegoal, String type , int userId) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {

            String getUserQuery = "Select uid from User where uid = " + userId;
            ResultSet resultSet = statement.executeQuery(getUserQuery);
            int userIdValue = resultSet.getInt("uid");

            String insertQuery = "INSERT INTO WorkoutPlan ( WPname, timegoal,type , UserID)" +
                    " VALUES ( '" + WPname + "', '" + timegoal + "','" + type + "' ," + userIdValue + ")";

            statement.executeUpdate(insertQuery);
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to insert data.");
            e.printStackTrace();
        }
    }

    // works
    private static void updateWorkout(int wpid, String WPname, int timegoal, String type ) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {


            String updateQuery = "UPDATE WorkoutPlan SET WPname= '" + WPname + "', timegoal = '" + timegoal + "', type = '" + type + "' WHERE WPID = " + wpid;
            statement.executeUpdate(updateQuery);
            System.out.println("Data updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update data.");
            e.printStackTrace();
        }
    }


    private static void deleteWorkout(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkoutDB.db");
             Statement statement = connection.createStatement()) {

            String deleteQuery = "DELETE FROM WorkoutPlan WHERE WPID = " + id;
            statement.executeUpdate(deleteQuery);
            System.out.println("Data deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete data.");
            e.printStackTrace();
        }
    }
}

