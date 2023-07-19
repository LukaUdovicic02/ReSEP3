using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;
using Blazor_T1.Pages;

public class WorkoutPlanHttpClient : IWorkoutPlanService
{
    private readonly HttpClient httpClient;

    public WorkoutPlanHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task<List<WorkoutPlan>> GetWorkoutPlans()
    {
        string apiUrl = "/api/workoutplans"; // Replace with your actual API endpoint

        return await httpClient.GetFromJsonAsync<List<WorkoutPlan>>(apiUrl);
    }

    public async Task<WorkoutPlan> GetWorkoutPlanById(int id)
    {
        string apiUrl = $"/api/workoutplans/{id}"; // Replace with your actual API endpoint

        return await httpClient.GetFromJsonAsync<WorkoutPlan>(apiUrl);
    }

    public async Task<bool> CreateWorkoutPlan(WorkoutPlan plan)
    {
        string apiUrl = "/api/workoutplans"; // Replace with your actual API endpoint

        var response = await httpClient.PostAsJsonAsync(apiUrl, plan);

        return response.IsSuccessStatusCode;
    }

    public async Task<bool> UpdateWorkoutPlan(WorkoutPlan plan)
    {///ask NIcola
        string apiUrl = $"/api/workoutplans/{plan.ToString()}"; // Replace with your actual API endpoint

        var response = await httpClient.PutAsJsonAsync(apiUrl, plan);

        return response.IsSuccessStatusCode;
    }

    public async Task<bool> DeleteWorkoutPlan(int id)
    {
        string apiUrl = $"/api/workoutplans/{id}"; // Replace with your actual API endpoint

        var response = await httpClient.DeleteAsync(apiUrl);

        return response.IsSuccessStatusCode;
    }
}