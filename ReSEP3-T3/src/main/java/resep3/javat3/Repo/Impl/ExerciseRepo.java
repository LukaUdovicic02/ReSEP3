package resep3.javat3.Repo.Impl;


import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IExerciseRepo;
import resep3.javat3.model.Exercise;
import resep3.javat3.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@GRpcService
public class ExerciseRepo implements IExerciseRepo {
    private final DBConnection initializer = new DBConnection();

    public void CreateExercise(Exercise exercise) throws SQLException {
        try {
            initializer.connect();

            try (Connection connection = initializer.getConnection();
                 PreparedStatement statement = connection.prepareStatement("insert into Exercise (exerciseName, numberOfSets, numberOfReps, WorkoutPlanID) VALUES (?,?,?,?)")) {

                statement.setString(1, exercise.getEName());
                statement.setInt(2, exercise.getNrOfSets());
                statement.setInt(3, exercise.getNrOfReps());
                statement.setInt(3, exercise.getWorkoutId());

                statement.executeUpdate();
                System.out.println("Exercise created");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Exercise failed to be created");
        }
        initializer.disconnect();
    }

}
