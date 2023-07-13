using System.Threading.Tasks;
using Model;

namespace WebApi.Service
{
    public interface IUserService
    {
        Task<User> ValidateUser(string userName, string password);
        Task RegisterUser(User user);
    }
}