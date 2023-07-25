using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.gRPClient;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("WorkoutPlan")]
    public class WorkoutPlanController : ControllerBase
    {
        private readonly IWorkoutPlanLogic _workoutPlanLogic;

        public WorkoutPlanController([FromServices] IWorkoutPlanLogic workoutPlanLogic)
        {
            _workoutPlanLogic = workoutPlanLogic;
        }


        [HttpPost]
        public async Task<ActionResult<WorkoutPlan>> CreateWorkout([FromBody] WorkoutPlan wp)
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

        [HttpGet]
        public async Task<ActionResult<WorkoutPlan>> GetWorkoutPlans()
        {
            try
            {
                IEnumerable<WorkoutPlan> workoutPlans = _workoutPlanLogic.GetAllWorkoutPlans().Result;
                return Ok(workoutPlans);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult<WorkoutPlan>> DeleteWorkoutPlan(int id)
        {
            try
            {
                await _workoutPlanLogic.DeleteWorkoutPlan(id);
                return Ok(id);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpPut("{wpid}")]
        public async Task<IActionResult> UpdateWorkout(int wpid, [FromBody] WorkoutPlan workoutPlan)
        {
            try
            {
                await _workoutPlanLogic.UpdateWorkout(workoutPlan);
                return Ok(workoutPlan);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpGet("{wpid}")]
        public async Task<ActionResult<WorkoutPlan>> GetWorkoutPlanById(int wpid)
        {
            try
            {
                var workoutPlan = await _workoutPlanLogic.GetWorkoutPlanById(wpid);
                if (workoutPlan == null)
                {
                    return NotFound(); 
                }
                return Ok(workoutPlan);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

    }
}