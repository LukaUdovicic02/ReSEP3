using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.Logic.LogicInterfaces
{
    public interface IWorkoutPlanLogic
    {
        Task CreateWorkout(WorkoutPlan workoutPlanLogicToBeCreated);
        Task<IEnumerable<WorkoutPlan>> GetAllWorkoutPlans();
        Task DeleteWorkoutPlan(int id);
        
    }
}