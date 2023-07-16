using System.Threading.Tasks;
using Model;

namespace Domain.gRPClient.RepoInterfaces
{
    public interface IRepoRegister
    {
        Task RegisterUser(User user);
    }
}