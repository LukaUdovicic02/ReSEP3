using System.Net.Http.Json;
using System.Text.Json;
using Model;


public class ExerciseHttpClient : IExerciseService
{
    private readonly HttpClient httpClient;
    
    public ExerciseHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }
    public async Task<Exercise> CreateExercise(Exercise exercise)
    {
        
        exercise.eid = DataSession.Instance.User.Uid; ///take care here

        HttpResponseMessage response = await httpClient.PostAsJsonAsync("http://localhost:5052/WorkoutPlan", exercise); //replace with actual endpoint
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
        HttpResponseMessage response = await httpClient.DeleteAsync($"http://localhost:5052/WorkoutPlan/{id}");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not delete the exercise");
        }
    }
}