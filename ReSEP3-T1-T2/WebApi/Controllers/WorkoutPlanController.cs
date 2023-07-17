using System;
using System.Threading.Tasks;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("workoutplan")]
    public class WorkoutPlanController : ControllerBase
    {
        private readonly IWorkoutPlanLogic _workoutPlanLogic;

        public WorkoutPlanController([FromServices]IWorkoutPlanLogic workoutPlanLogic)
        {
            _workoutPlanLogic = workoutPlanLogic;
        }

        [HttpPost]
        public async Task<ActionResult<WorkoutPlan>> CreateWorkout([FromBody]WorkoutPlan wp)
        {
            try
            {
                await _workoutPlanLogic.CreateWorkout(wp);
                return Ok(wp);
            }
            
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
                
            }
        }
    }
}