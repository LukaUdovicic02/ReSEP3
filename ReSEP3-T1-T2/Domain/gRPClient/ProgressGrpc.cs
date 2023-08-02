using Domain.gRPClient.RepoInterfaces;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient;

public class ProgressGrpc:IRepoProgress
{
    public async Task AddProgress(Progress _progress)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new ProgressService.ProgressServiceClient(channel);
        Console.WriteLine("Connection established");

        var reply = await client.AddProgressAsync(new ProgressRequest
        {
            Date = _progress.Date.ToUniversalTime().ToString("yyyy-MM-ddTHH:mm:ssZ"),
            BodyWeight = _progress.BodyWeight,
            FatPercentage = _progress.FatPercentage,
            // If your gRPC service expects more fields, add them here
        });

        Console.WriteLine("Successfully added progress with ID: " + reply.ProgressId);
    }
}