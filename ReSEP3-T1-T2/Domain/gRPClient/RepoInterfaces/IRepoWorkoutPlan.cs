using System.Threading.Tasks;
using Model;

namespace Domain.gRPClient.RepoInterfaces
{
    public interface IRepoWorkoutPlan
    {
        Task CreateWorkout(WorkoutPlan workoutPlan);
    }
}