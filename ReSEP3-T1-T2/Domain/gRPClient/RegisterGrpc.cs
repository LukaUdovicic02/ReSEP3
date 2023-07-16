using System;
using System.Threading.Tasks;
using domain.grpClient;
using Domain.gRPClient.RepoInterfaces;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient
{
    public class RegisterGrpc : IRepoRegister
    {
        public async Task RegisterUser(User user)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new RegisterService.RegisterServiceClient(channel);
            Console.WriteLine("connection test");
            var reply = await client.registerAsync(new RegisterRequest
            {
                Username = user.Username,
                Password = user.Password,
            });
            
            Console.WriteLine(reply.Message);
            Console.WriteLine(reply.Success);
            
            
        }
    }
}