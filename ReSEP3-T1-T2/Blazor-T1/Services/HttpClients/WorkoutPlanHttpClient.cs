using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components;
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

    public async Task<WorkoutPlan> GetWorkoutPlanById(int wpid)
    {
        Console.WriteLine(wpid);
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/WorkoutPlan/{wpid}");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not fetch the workout plan");
        }

        string message = await response.Content.ReadAsStringAsync();
        WorkoutPlan result = JsonSerializer.Deserialize<WorkoutPlan>(message, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        });
        
        return result;
    }


    public async Task<WorkoutPlan> CreateWorkoutPlan(WorkoutPlan plan)
    {
        plan.UserID = DataSession.Instance.User.Uid;

        HttpResponseMessage response = await httpClient.PostAsJsonAsync("http://localhost:5052/WorkoutPlan", plan);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        WorkoutPlan w = JsonSerializer.Deserialize<WorkoutPlan>(result, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        })!;

        return w;
    }

    public async Task UpdateWorkoutPlan(WorkoutPlan plan)
    {
      
        string apiUrl = $"http://localhost:5052/WorkoutPlan/{plan.Wpid}";
        var response = await httpClient.PutAsJsonAsync(apiUrl, plan);

        if (!response.IsSuccessStatusCode)
        {
            string errorMessage = await response.Content.ReadAsStringAsync();
            throw new Exception(errorMessage);
        }
      
    }
    
    
    

    
    public async Task DeleteWorkoutPlan(int id)
    {
        HttpResponseMessage response = await httpClient.DeleteAsync($"http://localhost:5052/WorkoutPlan/{id}");
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception("could not delete the workout plan");
        }
    }
}