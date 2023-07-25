package resep3.javat3.Repo.Interfaces;

import resep3.javat3.model.Exercise;

import java.sql.SQLException;

public interface IExerciseRepo
{
    void CreateExercise(Exercise exercise) throws SQLException;
}
