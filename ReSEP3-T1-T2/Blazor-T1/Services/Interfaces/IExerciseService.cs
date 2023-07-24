using Model;

public interface IExerciseService
{
    Task<List<Exercise>> GetExercises();
    Task<Exercise> GetExerciseById(int id);
    Task<bool> CreateExercise(Exercise exercise);

}