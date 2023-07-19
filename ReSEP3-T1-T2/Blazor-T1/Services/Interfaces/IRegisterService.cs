using Model;

namespace Blazor;

public interface IRegisterService
{
    Task<bool> Register(User user);
}