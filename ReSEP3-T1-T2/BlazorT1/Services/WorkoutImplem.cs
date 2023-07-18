using BlazorT1.Data;
using System.Net.Http;
using System.Text;
using System.Text.Json;


namespace BlazorT1.Services;

public class WorkoutImpl:IWorkout
{
    private readonly HttpClient httpClient;

    public WorkoutImpl(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task<List<Workout>> GetWorkouts()
    {
        var response = await httpClient.GetAsync("api/workouts");

        response.EnsureSuccessStatusCode();

        var responseBody = await response.Content.ReadAsStringAsync();
        var workouts = JsonSerializer.Deserialize<List<Workout>>(responseBody);

        return workouts;
    }

    public async Task CreateWorkout(Workout workout)
    {
        var workoutJson = new StringContent(JsonSerializer.Serialize(workout), Encoding.UTF8, "application/json");

        var response = await httpClient.PostAsync("api/workouts", workoutJson);

        response.EnsureSuccessStatusCode();
    }

    public async Task DeleteWorkout(int workoutId)
    {
        var response = await httpClient.DeleteAsync($"api/workouts/{workoutId}");

        response.EnsureSuccessStatusCode();
    }
}
