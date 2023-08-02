using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using domain.grpClient;
using Domain.gRPClient.RepoInterfaces;
using Domain.Logic;
using Grpc.Net.Client;
using Model;

namespace Domain.gRPClient
{
    public class ExerciseGrpc : IRepoExercise
    {
        public async Task<List<Exercise>> GetAllExercises()
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getAllExercisesAsync(new GetAllExercisesRequest());

            List<Exercise> exercises = new List<Exercise>();

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

        public async Task<IEnumerable<Exercise>> GetExByWid(int wid)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("connection established");

            var reply = await client.getExByWidAsync(new getExByWidRequest
            {
                Wpid = wid,
            });

            IList<Exercise> exercises = new List<Exercise>();

            foreach (var edata in reply.Data)
            {
                Exercise ex = new Exercise
                {
                    EId = edata.Eid,
                    EName = edata.EName,
                    NrOfReps = edata.NrOfReps,
                    NrOfSets = edata.NrOfSets,
                    WorkoutPlanId = edata.WorkoutId,
                };
                exercises.Add(ex);
            }

            return exercises;
        }

        public async Task<Exercise> CreateExercise(Exercise exerciseGrpc)
        {
            using var channel = GrpcChannel.ForAddress("http://localhost:6565");
            var client = new ExerciseService.ExerciseServiceClient(channel);
            Console.WriteLine("Connection ees");

            var reply = await client.createExerciseAsync(new CreateExerciseRequest
            {
                EName = exerciseGrpc.EName,
                NrOfSets = exerciseGrpc.NrOfSets,
                NrOfReps = exerciseGrpc.NrOfReps
            });

            Console.WriteLine("This is ID of the created exercise: " + reply.Eid);

            return new Exercise
            {
                EId = reply.Eid,
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
         
            var replay=await client.deleteExerciseAsync(new DeleteExerciseRequest
            {
                EId = id
            });

            Console.WriteLine("Successfully deleted exercise with ID: "+id);
        }
    }
}