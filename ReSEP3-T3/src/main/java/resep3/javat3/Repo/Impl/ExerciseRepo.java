package resep3.javat3.Repo.Impl;


import org.lognet.springboot.grpc.GRpcService;
import resep3.javat3.Repo.Interfaces.IExerciseRepo;
import resep3.javat3.model.Exercise;
import resep3.javat3.persistance.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@GRpcService
public class ExerciseRepo implements IExerciseRepo {
    private final DBConnection initializer = new DBConnection();

    public void CreateExercise(Exercise exercise)  {
        try {
            initializer.connect();

            try (Connection connection = initializer.getConnection();
                 PreparedStatement statement = connection.prepareStatement("insert into Exercise (exerciseName, numberOfSets, numberOfReps, WorkoutPlanID) VALUES (?,?,?,?)")) {

                statement.setString(1, exercise.getEName());
                statement.setInt(2, exercise.getNrOfSets());
                statement.setInt(3, exercise.getNrOfReps());
                statement.setInt(4, exercise.getWorkoutId());

                statement.executeUpdate();
                System.out.println("Exercise created");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Exercise failed to be created");
        }
        initializer.disconnect();
    }


    public ArrayList<Exercise> GetAllExercises() {

        initializer.connect();
        ArrayList<Exercise> exercises = new ArrayList<>();

        try {
            Connection connection = initializer.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Exercise");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setEid(resultSet.getInt("EID"));
                exercise.setEName(resultSet.getString("exerciseName"));
                exercise.setNrOfSets(resultSet.getInt("numberOfSets"));
                exercise.setNrOfReps(resultSet.getInt("numberOfReps"));
                exercise.setWorkoutId(resultSet.getInt("WorkoutPlanID"));

                exercises.add(exercise);

            }

            System.out.println("Fetched all exercises of the workout plan");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Could not fetch all exercises of the workout plan");
        }

        initializer.disconnect();


        return exercises;
    }

}
