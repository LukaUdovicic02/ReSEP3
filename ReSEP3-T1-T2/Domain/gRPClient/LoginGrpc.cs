using System;
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


            return await Task.FromResult(new User(request.Username, request.Password));
        }

      
    }
}