package resep3.javat3.persistance;

import resep3.javat3.model.WorkoutPlan;

import java.sql.*;
import java.util.ArrayList;

public class DBInitCreateWorkout {

    public static void main(String[] args) throws SQLException {

      //  insertWorkoutPlan("chestworkout" , 2 , "chest" , 1);
      // updateWorkout(2 , "legworkout" , 30 , "leg");
     //   deleteWorkout(2);
        getWpByUserId(1);

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

    private static ArrayList<WorkoutPlan> getWpByUserId(int userid) throws SQLException {
        final DBConnection initializer = new DBConnection();
        ArrayList<WorkoutPlan> workoutPlans = new ArrayList<>();
        initializer.connect();

        Connection connection = initializer.getConnection();
        Statement statement = connection.createStatement();
        String selectQuery = "Select UserID from WorkoutPlan where userid = " + userid;

        System.out.println(selectQuery);

        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (resultSet.next())
        {
            WorkoutPlan workoutPlan = new WorkoutPlan(userid);
            workoutPlans.add(workoutPlan);
            System.out.println(workoutPlans);
        }



        return workoutPlans;
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

