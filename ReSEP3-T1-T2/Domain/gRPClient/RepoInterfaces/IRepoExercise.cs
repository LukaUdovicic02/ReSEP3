using Model;

namespace Domain.gRPClient.RepoInterfaces;

public interface IRepoExercise
{
    Task<Exercise> CreateExercise(Exercise exercise);
    Task DeleteExercise(int id);
}