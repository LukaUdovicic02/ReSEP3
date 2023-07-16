using System;
using System.Threading.Tasks;
using Domain.gRPClient.RepoInterfaces;
using Domain.Logic.LogicInterfaces;
using Model;

namespace Domain.Logic
{
    public class UserLogic : IUserLogic
    {

        private readonly IRepoLogin _repoLogin;
        private readonly IRepoRegister _repoRegister;

        public UserLogic(IRepoLogin login, IRepoRegister register)
        {
            _repoLogin = login;
            _repoRegister = register;
        }

        public async Task<User> ValidateUser(string userName, string password)
        {
           return await _repoLogin.ValidateUser(userName, password);
        }

        public async Task RegisterUser(User userToBeCreated)
        {
            string userName =  userToBeCreated.Username;

            if (userName.Length < 3)
                throw new Exception("Username must be at least 3 characters!");

            if (userName.Length > 50)
                throw new Exception("Username must be less than 50 characters!");
            
        }
    }
}