using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

public interface IExerciseService
{
    Task DeleteExercise(int id);
    Task<Exercise> GetExerciseById(int id);
    Task<Exercise> CreateExercise(Exercise exercise);
    Task<List<Exercise>> GetAllExercises();
}