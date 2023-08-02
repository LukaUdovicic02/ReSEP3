using Model;

namespace Domain.gRPClient.RepoInterfaces;

public interface IRepoProgress
{
    Task AddProgress(Progress _progress);
    
}