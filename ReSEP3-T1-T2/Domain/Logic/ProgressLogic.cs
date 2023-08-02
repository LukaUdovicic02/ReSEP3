using Domain.gRPClient.RepoInterfaces;
using Domain.Logic.LogicInterfaces;
using Model;

namespace Domain.Logic;

public class ProgressLogic:IProgress
{
    private readonly IRepoProgress _repoProgress;
    
    public ProgressLogic(IRepoProgress _progress)
    {
        _repoProgress = _progress;
    }

    public Task AddProgress(Progress _progress)
    {
        throw new NotImplementedException();
    }
}