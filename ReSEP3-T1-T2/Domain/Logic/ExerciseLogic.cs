using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.gRPClient.RepoInterfaces;
using Domain.Logic.LogicInterfaces;
using Model;

namespace Domain.Logic
{
    public class ExerciseLogic : IExerciseLogic
    {
        private readonly IRepoExercise _exercise;

        public ExerciseLogic(IRepoExercise exercise)
        {
            _exercise = exercise;
        }

        public async Task CreateExercise(Exercise exercise)
        {
            try
            {
                await _exercise.CreateExercise(exercise);
                Console.WriteLine("Exercise created successfully.");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error creating exercise: " + ex.Message);
                throw; 
            }
        }

        public async Task DeleteExercise(int id)
        {
            try
            {
                await _exercise.DeleteExercise(id);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async Task<IList<Exercise>> GetAllExercises()
        {
            return await _exercise.GetAllExercises();
        }
        
    }
}