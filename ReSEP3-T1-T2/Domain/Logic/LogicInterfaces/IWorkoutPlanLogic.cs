using System.Threading.Tasks;
using Model;

namespace Domain.Logic.LogicInterfaces
{
    public interface IWorkoutPlan
    {
        Task CreateWorkout(WorkoutPlan workoutPlanLogicToBeCreated);
    }
}