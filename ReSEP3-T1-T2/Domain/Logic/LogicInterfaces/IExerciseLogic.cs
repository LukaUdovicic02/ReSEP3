using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.Logic.LogicInterfaces
{
    public interface IExerciseLogic
    {
        Task CreateExercise(Exercise exercise);
        Task DeleteExercise(int id);

      Task<IList<Exercise>> GetAllExercises();
      
      Task<IEnumerable<Exercise>> GetExByWid(int wid);

      

    }
}