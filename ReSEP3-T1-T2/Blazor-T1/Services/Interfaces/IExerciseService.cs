using Model;



public interface IExerciseService
{
    Task<Exercise> CreateExercise(Exercise exercise);
    Task DeleteExercise(int id);
}