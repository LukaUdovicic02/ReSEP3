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
             
             // should we have kind of unique workout
        }
    }
}