using System.Threading.Tasks;
using Model;


namespace Domain
{
    public interface IUserValidation
    {
        Task<User> ValidateUser(string userName, string password);
        Task RegisterUser(User user);
    }
    
}