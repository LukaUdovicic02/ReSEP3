using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.gRPClient.RepoInterfaces
{
    public interface IRepoWorkoutPlan
    {
        Task CreateWorkout(WorkoutPlan workoutPlan);
        Task<IEnumerable<WorkoutPlan>> GetAllWorkoutPlans();
        Task DeleteWorkoutPlan(int id);
        
        Task UpdateWorkout(WorkoutPlan workoutPlan);
        

    }
}