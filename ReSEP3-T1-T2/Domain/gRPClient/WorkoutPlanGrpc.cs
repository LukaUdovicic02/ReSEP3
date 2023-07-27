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

        
        
        public async Task UpdateWorkout(WorkoutPlan workoutPlan)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new WorkoutPlanService.WorkoutPlanServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = client.updateWorkoutPlanAsync(new UpdateWorkoutPlanRequest
            {
                Wpid = workoutPlan.Wpid,
                Wpname = workoutPlan.WPname,
                Timegoal = workoutPlan.Timegoal,
                Type = workoutPlan.Type,
                Userid = workoutPlan.UserID,
                
            });
            Console.WriteLine("Successfully updated workout plan with an User Id of :" + " " + reply.ResponseAsync.Result.Wpid);
        }


        public async Task<WorkoutPlan> GetWorkoutPlanById(int wpid)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new WorkoutPlanService.WorkoutPlanServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getWorkoutPlanByIdAsync(new GetWorkoutPlanRequest
            {
                Wpid = wpid
            });

            if (reply.Data != null && reply.Data.Count > 0)
            {
                var workoutPlanData = reply.Data[0]; 
                var workoutPlan = new WorkoutPlan
                {
                    Wpid = workoutPlanData.Wpid,
                    WPname = workoutPlanData.Wpname,
                    Timegoal = workoutPlanData.Timegoal,
                    Type = workoutPlanData.Type,
                    UserID = workoutPlanData.Userid,
                };

                Console.WriteLine("Successfully fetched the workout plan: " + workoutPlan.WPname);

                return workoutPlan;
            }

           
            return null;
        }

    }
}