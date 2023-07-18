using System;
using System.Threading.Tasks;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("controller")]
    public class LoginController : ControllerBase
    {
        private readonly IUserLogic userLogic;

        public LoginController([FromServices] IUserLogic userLogic)
        {
            this.userLogic = userLogic;
        }

        [HttpGet]
        [Route("{username}/{password}")]
        public async Task<ActionResult<User>> ValidateUser([FromRoute] string username,[FromRoute] string password )
        {
            try
            {
                User user = userLogic.ValidateUser(username, password).Result;
                return Ok(user);
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
            }catch (Exception e) {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
    }
}