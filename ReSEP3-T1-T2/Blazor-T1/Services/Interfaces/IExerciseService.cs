using Model;

public interface IExerciseService
{
    Task<List<Exercise>> GetExercises();
    Task<Exercise> GetExerciseById(int id);
    Task<Exercise> CreateExercise(Exercise exercise);

}