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

        public async Task<IList<Exercise>> GetAllExercises()
        {
            return await _exercise.GetAllExercises();
        }
    }
}