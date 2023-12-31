﻿using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("LogIn")]
    public class LoginController : ControllerBase
    {
        private readonly IUserLogic userLogic;

        public LoginController([FromServices] IUserLogic userLogic)
        {
            this.userLogic = userLogic;
        }

        [HttpGet]
        [Route("{username}/{password}")]
        public async Task<ActionResult<User>> ValidateUser([FromRoute] string username, [FromRoute] string password)
        {
            try
            {
                User user = await userLogic.ValidateUser(username, password);
                return Ok(user);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<IEnumerable<WorkoutPlan>>> GetWpByUserID(int id)
        {
            try
            {
                IEnumerable<WorkoutPlan> workoutPlans = await userLogic.GetWpByUserID(id);
                return Ok(workoutPlans);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpPost]
        public async Task<ActionResult<User>> RegisterUser([FromBody] User user)
        {
            try
            {
                await userLogic.RegisterUser(user);
                return Ok(user);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
    }
}