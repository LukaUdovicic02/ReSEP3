﻿using System.Collections.Generic;
using System.Threading.Tasks;
using Model;

namespace Domain.Logic.LogicInterfaces
{
    public interface IUserLogic
    {
        Task<User> ValidateUser(string userName, string password);
        Task RegisterUser(User user);
        Task<IEnumerable<WorkoutPlan>> GetWpByUserID(int id);
    }
    
}