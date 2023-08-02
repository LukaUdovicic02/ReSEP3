using Model;

namespace Domain.Logic.LogicInterfaces;

public interface IProgress
{
    Task AddProgress(Progress _progress);
   // Task DeleteProgress(int id);
}