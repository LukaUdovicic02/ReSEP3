using BlazorT1.Data;

namespace BlazorT1.Services;

public interface IAuthService
{
    public Task<User> ValidateUser(string username, string password);
    public Task RegisterUser(User user);
}