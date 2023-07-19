using Model;

namespace Blazor;

public interface ILoginService
{
    Task<User> Login(string username, string password);
    
}