using System.Collections.Generic;
using System.Threading.Tasks;
using Blazor_T1.Pages;

public interface IWorkoutPlanService
{
    Task<List<WorkoutPlan>> GetWorkoutPlans();
    Task<WorkoutPlan> GetWorkoutPlanById(int id);
    Task<bool> CreateWorkoutPlan(WorkoutPlan plan);
    Task<bool> UpdateWorkoutPlan(WorkoutPlan plan);
    Task<bool> DeleteWorkoutPlan(int id);
}
