using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using domain.grpClient;
using Domain.gRPClient.RepoInterfaces;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient
{
    public class ExerciseGrpc : IRepoExercise
    {
        public async Task<IList<Exercise>> GetAllExercises()
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getAllExercisesAsync(new GetAllExercisesRequest());

            IList<Exercise> exercises = new List<Exercise>();

            foreach (var data in reply.Data)
            {
                Exercise exercise = new Exercise
                {
                    EId = data.Eid,
                    EName = data.EName,
                    NrOfReps = data.NrOfReps,
                    NrOfSets = data.NrOfSets,
                    WorkoutPlanId = data.WorkoutId,
                };
                exercises.Add(exercise);
            }
            

            Console.WriteLine(reply);

            return exercises;
        }
        public async Task<Exercise> CreateExercise(Exercise exerciseGrpc)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("Connection ees");

            var reply = await client.createExerciseAsync(new ExerciseRequest
            {
                ExName = exerciseGrpc.EName,
                NrOfSets = exerciseGrpc.NrOfSets,
                NrOfReps = exerciseGrpc.NrOfReps
            });

            Console.WriteLine("This is ID of the created exercise: " + reply.ExId);

            return new Exercise
            {
                EId = reply.ExId,
                EName = exerciseGrpc.EName,
                NrOfSets = exerciseGrpc.NrOfSets,
                NrOfReps = exerciseGrpc.NrOfReps
            };
        }

        public async Task DeleteExercise(int id)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("Connect yes");
         
            var replay=await client.deleteExerciseAsync(new ExerciseRequest 
            {
                ExId = id
            });

            Console.WriteLine("Successfully deleted exercise with ID: "+id);
        }
    }
}