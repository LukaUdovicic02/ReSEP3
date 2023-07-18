using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using domain.grpClient;
using Domain.gRPClient.RepoInterfaces;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient
{
    public class WorkoutPlanGrpc : IRepoWorkoutPlan
    {
        public async Task CreateWorkout(WorkoutPlan workoutPlan)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new WorkoutPlanService.WorkoutPlanServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.createWorkoutPlanAsync(new WorkoutPlanRequest
            {
                WpName = workoutPlan.WPname,
                TimeGoal = workoutPlan.Timegoal,
                Type = workoutPlan.Type,
                UserID = workoutPlan.UserID,
            });

            Console.WriteLine("this is ID of the workout : " + reply.Wpid);
        }

        public async Task<IEnumerable<WorkoutPlan>> GetAllWorkoutPlans()
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new WorkoutPlanService.WorkoutPlanServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getWorkoutPlanAsync(new GetWorkoutPlanRequest()
            );

            IList<WorkoutPlan> workoutPlans = new List<WorkoutPlan>();

            foreach (var data in reply.Data)
            {
                var workoutPlan = new WorkoutPlan
                {
                    Wpid = data.Wpid,
                    WPname = data.Wpname,
                    Timegoal = data.Timegoal,
                    Type = data.Type,
                    UserID = data.Userid,
                };
                workoutPlans.Add(workoutPlan);
            }


            Console.WriteLine(" Number of the workout plans " + reply.Data.Count);


            return workoutPlans;
        }

        public async Task DeleteWorkoutPlan(int id)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new WorkoutPlanService.WorkoutPlanServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.deleteWorkoutPlanAsync(new DeleteWorkoutPlanRequest
            {
                Wpid = id,
            });

            Console.WriteLine("Successfully deleted workout plan ");
        }
    }
}