using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Model;

public class WorkoutPlanHttpClient : IWorkoutPlanService
{
    private readonly HttpClient httpClient;

    public WorkoutPlanHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task<List<WorkoutPlan>> GetWorkoutPlans()
    {

        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/WorkoutPlan");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not get the workout plans");
        }

        string message = await response.Content.ReadAsStringAsync();
        List<WorkoutPlan> result = JsonSerializer.Deserialize<List<WorkoutPlan>>(message);
        
        return result;



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