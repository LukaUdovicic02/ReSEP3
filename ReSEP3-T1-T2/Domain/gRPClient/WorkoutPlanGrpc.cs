using System;
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
                TimeGoal = workoutPlan.timegoal,
                Type = workoutPlan.Type,
                UserID = workoutPlan.UserID,
                
                
                
            });

            Console.WriteLine("this is ID of the workout : " + reply.Wpid);
        }
    }
}