

using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("Exercise")]
    public class ExerciseController : ControllerBase
    {
        private readonly IExerciseLogic _exerciseLogic;

        public ExerciseController([FromServices] IExerciseLogic exerciseLogic)
        {
            _exerciseLogic = exerciseLogic;
        }

       
         [HttpPost]
         public async Task<ActionResult<Exercise>> CreateExercise([FromBody] Exercise eid)
         {
             try
             {
                await _exerciseLogic.CreateExercise(eid);
                return Ok(eid);
            }
        
             catch (Exception e)
             {
                 Console.WriteLine(e);
                 return StatusCode(500, e.Message);
             }
         }
        
         
         
        [HttpGet]
        public async Task<ActionResult<Exercise>> GetAllExercises()
        {
            try
            {
                IList<Exercise> exercises = await _exerciseLogic.GetAllExercises();
                return Ok(exercises);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
    
        [HttpDelete("{id}")]
         public async Task<ActionResult<Exercise>> DeleteExercise(int id)
         {
             try
            {
                await _exerciseLogic.DeleteExercise(id);
                return Ok(id);
            }
             catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
         }

    }
}
