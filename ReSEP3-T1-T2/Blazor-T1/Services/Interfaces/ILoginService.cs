using System.Threading.Tasks;
using Model;


public interface ILoginService
{
    Task<User> Login(string username, string password);
    
}