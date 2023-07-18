using BlazorT1.Data;
using BlazorT1.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authorization;
using BlazorT1.Services;




namespace BlazorT1.Controllers;

[ApiController]
[Route("[controller]")]
[Authorize]


    public class AuthController:ControllerBase
    {
        
        private readonly IAuthService authService;

        public AuthController(IAuthService authService)
        {
            this.authService = authService;
        }

        [HttpPost,Route("register")]
        public async Task<ActionResult> Register([FromBody] User user)
        {
            await authService.RegisterUser(user);
            return Ok();
        }

        [HttpPost, Route("login")]
        public async Task<ActionResult> Login([FromBody] User user)
        {
            try
            {
               await authService.ValidateUser(user.Username, user.Password);

                return Ok();
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }
    }