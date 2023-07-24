using System.Collections.Generic;
using System.Threading.Tasks;
using Blazor_T1.Pages;
using Model;

public interface IWorkoutPlanService
{
    Task<List<WorkoutPlan>> GetWorkoutPlans();
    Task<WorkoutPlan> GetWorkoutPlanById(int id);
    Task<bool> CreateWorkoutPlan(WorkoutPlan plan);
    Task UpdateWorkoutPlan(WorkoutPlan plan);
    Task DeleteWorkoutPlan(int id);
}
