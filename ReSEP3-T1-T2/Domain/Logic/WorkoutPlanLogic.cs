using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.gRPClient.RepoInterfaces;
using Domain.Logic.LogicInterfaces;
using Model;


namespace Domain.Logic
{
    public class WorkoutPlanLogic : IWorkoutPlanLogic
    {
        private readonly IRepoWorkoutPlan _workoutPlan;

        public WorkoutPlanLogic(IRepoWorkoutPlan plan)
        {
            this._workoutPlan = plan;
        }


        public async Task CreateWorkout(WorkoutPlan workoutPlanLogicToBeCreated)
        {
            await _workoutPlan.CreateWorkout(workoutPlanLogicToBeCreated);
        }

        public async Task<IEnumerable<WorkoutPlan>> GetAllWorkoutPlans()
        {
            return await _workoutPlan.GetAllWorkoutPlans();
        }

        public async Task DeleteWorkoutPlan(int id)
        {
            await _workoutPlan.DeleteWorkoutPlan(id);
        }
        public async Task UpdateWorkout(int id)
        {
            await _workoutPlan.DeleteWorkoutPlan(id);
        }
    }
}