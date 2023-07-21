using System.Collections.Generic;
using System.Threading.Tasks;
using Model;


public interface ILoginService
{
    Task<User> Login(string username, string password);
    Task<IEnumerable<WorkoutPlan>> GetWpByUserID(int id);

}