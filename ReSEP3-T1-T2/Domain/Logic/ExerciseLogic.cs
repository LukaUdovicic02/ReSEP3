using System.Threading.Tasks;
using Domain.Logic.LogicInterfaces;
using Model;

namespace Domain.Logic
{
    public class ExerciseLogic : IExerciseLogic
    {
        
        // Takes from repo interface
        private readonly IExerciseLogic _exercise;

        public ExerciseLogic(IExerciseLogic exercise)
        {
            _exercise = exercise;
        }
        public async Task CreateExercise(Exercise exerciseLogicToBeCreated)
        {
            await _exercise.CreateExercise(exerciseLogicToBeCreated);
        }
        public async Task DeleteExercise(int id)
        {
            await _exercise.DeleteExercise(id);
        }
    }
}