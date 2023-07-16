package resep3.javat3.Repo.Impl;


import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IWorkoutRepo;
import resep3.javat3.model.WorkoutPlan;
import resep3.javat3.persistance.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@GRpcService
public class WorkoutRepo implements IWorkoutRepo
{
    private final DBConnection initializer = new DBConnection();

    public void createWorkoutPlan(WorkoutPlan workoutPlan) {

        try (Connection connection = initializer.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO WorkoutPlan (WPname, timegoal, type, UserID) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, workoutPlan.getWpName());
            statement.setInt(2, workoutPlan.getTimeGoal());
            statement.setString(3, workoutPlan.getType());
            statement.setInt(4, workoutPlan.getUserID());

            statement.executeUpdate();
            System.out.println("Workout plan created.");

            initializer.disconnect();

        } catch (SQLException e) {
            System.out.println("Failed to create WorkoutPlan.");
            e.printStackTrace();
        }
    }




}


