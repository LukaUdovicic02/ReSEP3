using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using domain.grpClient;
using Domain.gRPClient.RepoInterfaces;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient
{
    public class LoginGrpc : IRepoLogin
    {
        public async Task<User> ValidateUser(string userName, string password)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new LoginService.LoginServiceClient(channel);
            var request = new LoginRequest {Username = userName, Password = password};
            Console.WriteLine("connection test");
            var reply = await client.loginAsync(request);
            
            Console.WriteLine(reply.Message);
            Console.WriteLine(reply.Success);
            Console.WriteLine(reply.Uid);

            User user = new(reply.Uid, request.Username, request.Password);


            return await Task.FromResult(user);
        }
        
        
        public async Task<IEnumerable<WorkoutPlan>> GetWpByUserID(int id)
        {

            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new LoginService.LoginServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getWpByUserIDAsync(new GetWpByUserIdRequest
            {
                Userid = id,
            });

            IList<WorkoutPlan> workoutPlans = new List<WorkoutPlan>();

            foreach (var data in reply.Data)
            {
                var workout = new WorkoutPlan
                {
                    Wpid = data.Wpid,
                    Timegoal = data.Timegoal,
                    Type = data.Type,
                    UserID = data.Userid,
                    WPname = data.Wpname
                    
                };
                workoutPlans.Add(workout);
            }
            return workoutPlans;
        }

      
    }
}