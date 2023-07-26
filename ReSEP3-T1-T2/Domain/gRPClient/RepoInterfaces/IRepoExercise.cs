using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.gRPClient.RepoInterfaces
{
    public interface IRepoExercise
    {
        Task<IList<Exercise>> GetAllExercises();
    }
}