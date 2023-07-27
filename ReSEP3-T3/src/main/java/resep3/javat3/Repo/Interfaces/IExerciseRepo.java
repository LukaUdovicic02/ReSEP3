package resep3.javat3.Repo.Interfaces;

import resep3.javat3.model.Exercise;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IExerciseRepo
{
    void CreateExercise(Exercise exercise) throws SQLException;
    ArrayList<Exercise> GetAllExercises();
}
