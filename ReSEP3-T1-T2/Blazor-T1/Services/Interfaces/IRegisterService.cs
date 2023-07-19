using System.Threading.Tasks;
using Model;


public interface IRegisterService
{
    Task Register(User user);
}