using System.Threading.Tasks;
using Model;

namespace Domain.Logic.LogicInterfaces
{
    public interface IExerciseLogic
    {
        Task CreateExercise(Exercise exerciseLogicToBeCreated);
        Task DeleteExercise(int id);
    
    }
}