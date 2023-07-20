using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.gRPClient.RepoInterfaces
{
    public interface IRepoLogin
    {
        Task<User> ValidateUser(string userName, string password);
        Task<IEnumerable<WorkoutPlan>> GetWpByUserID(int id);
    }
}