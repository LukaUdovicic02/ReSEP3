namespace BlazorT1.Services;
using BlazorT1.Data;
public interface IWorkout
{
    Task<List<Workout>> GetWorkouts();
    Task CreateWorkout(Workout workout);
    Task DeleteWorkout(int workoutId);
}