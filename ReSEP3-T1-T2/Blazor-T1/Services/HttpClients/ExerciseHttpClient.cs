using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Model;


public class ExerciseHttpClient : IExerciseService
{
    private readonly HttpClient httpClient;
    
    public ExerciseHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public Task<Exercise> GetExerciseById(int id)
    {
        throw new NotImplementedException();
    }
    
    public async Task<Exercise> CreateExercise(Exercise exercise)
    {
        
        exercise.WorkoutPlanId = DataSession.Instance.WorkoutPlan.Wpid;

        HttpResponseMessage response = await httpClient.PostAsJsonAsync("http://localhost:5052/Exercise", exercise); 
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        Exercise w = JsonSerializer.Deserialize<Exercise>(result, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        })!;
        
        
        return w;
    }


    public async Task DeleteExercise(int id)
    {
        HttpResponseMessage response = await httpClient.DeleteAsync($"http://localhost:5052/Exercise/{id}");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not delete the exercise");
        }
    }

    public async Task<List<Exercise>> GetAllExercises()
    {
        
        
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/Exercise");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not get the exercises");
        }

        string message = await response.Content.ReadAsStringAsync();
        List<Exercise> result = JsonSerializer.Deserialize<List<Exercise>>(message);

        return result;
    }
    
    
    
    public async Task<IEnumerable<Exercise>> GetExByWid(int wid)
    {
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/Exercise/{wid}");
        response.EnsureSuccessStatusCode();

        string message = await response.Content.ReadAsStringAsync();
        IEnumerable<Exercise> result = JsonSerializer.Deserialize<List<Exercise>>(message);

        return result;
    }

}