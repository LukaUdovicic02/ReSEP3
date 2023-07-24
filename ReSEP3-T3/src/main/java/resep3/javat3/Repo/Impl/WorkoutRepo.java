package resep3.javat3.Repo.Impl;

import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IWorkoutRepo;
import resep3.javat3.model.User;
import resep3.javat3.model.WorkoutPlan;
import resep3.javat3.persistance.DBConnection;

import java.sql.*;
import java.util.ArrayList;

@GRpcService
public class WorkoutRepo implements IWorkoutRepo {
    private final DBConnection initializer = new DBConnection();

    public void createWorkoutPlan(WorkoutPlan workoutPlan) {

        try {

            initializer.connect();

            try (Connection connection = initializer.getConnection();
                 PreparedStatement statement = connection.prepareStatement(
                         "INSERT INTO WorkoutPlan (WPname, timegoal, type, UserID) VALUES (?, ?, ?, ?)")) {

                statement.setString(1, workoutPlan.getWpName());
                statement.setInt(2, workoutPlan.getTimeGoal());
                statement.setString(3, workoutPlan.getType());
                statement.setInt(4, workoutPlan.getUserID());

                statement.executeUpdate();
                System.out.println("Workout plan created.");


                try (ResultSet generatedAutoKeys = statement.getGeneratedKeys()) {
                    if (generatedAutoKeys.next()) {
                        int generatedId = generatedAutoKeys.getInt(1);
                        workoutPlan.setWpID(generatedId);
                        System.out.println("ID: " + generatedId);
                    } else {
                        throw new SQLException("Creating workout plan failed, no ID found.");
                    }
                }
            }
            initializer.disconnect();

        } catch (SQLException e) {
            System.out.println("Failed to create WorkoutPlan.");
            e.printStackTrace();
        }
    }

    public ArrayList<WorkoutPlan> getWorkoutPlans() {

        ArrayList<WorkoutPlan> workoutPlans = new ArrayList<>();

        try {
            initializer.connect();

            Connection connection = initializer.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM WorkoutPlan ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                WorkoutPlan workoutPlan = new WorkoutPlan();
                workoutPlan.setWpID(resultSet.getInt("WPID"));
                workoutPlan.setWpName(resultSet.getString("WPname"));
                workoutPlan.setTimeGoal(resultSet.getInt("timegoal"));
                workoutPlan.setType(resultSet.getString("type"));
                workoutPlan.setUserID(resultSet.getInt("UserID"));

                workoutPlans.add(workoutPlan);

            }

            System.out.println("Workout plans fetched.");

        } catch (Exception e) {
            System.out.println("Failed to fetch WorkoutPlans.");
            e.printStackTrace();
        }
        initializer.disconnect();
        return workoutPlans;

    }

    public void deleteWorkoutPlan(int id) {
        try {
            initializer.connect();
            Connection connection = initializer.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM WorkoutPlan WHERE WPID = ?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Workout plan with WPID " + id + " deleted.");
            } else {
                System.out.println("No workout plan found with WPID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete WorkoutPlan.");
            e.printStackTrace();
        } finally {
            initializer.disconnect();
        }
    }


    public void updateWorkoutPlan(WorkoutPlan workoutPlan) {

        try {

            initializer.connect();

            Connection connection = initializer.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE WorkoutPlan SET WPname= '" + workoutPlan.getWpName() +
                    "', timegoal = '" + workoutPlan.getTimeGoal() + "', UserID  = '" + workoutPlan.getUserID() + "'," +
                    " type = '" + workoutPlan.getType() + "' WHERE WPID = " + workoutPlan.getWpID());
            statement.executeUpdate();
            System.out.println("Data updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update data.");
        } finally {
            initializer.disconnect();
        }
    }


}
