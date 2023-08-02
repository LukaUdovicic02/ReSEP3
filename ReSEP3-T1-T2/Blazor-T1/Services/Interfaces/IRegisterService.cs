using System.Threading.Tasks;
using Model;


public interface IRegisterService
{
    Task<User> Register(User user);
}