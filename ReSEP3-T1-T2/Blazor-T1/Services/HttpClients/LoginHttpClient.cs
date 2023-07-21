using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Model;

public class LoginHttpClient : ILoginService
{
    private readonly HttpClient httpClient;

    public LoginHttpClient()
    {
        this.httpClient = new HttpClient();
    }

    public async Task<User> Login(string username, string password)
    {
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/LogIn/{username}/{password}");
        response.EnsureSuccessStatusCode();

        User user = await response.Content.ReadFromJsonAsync<User>(new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        });

        if (user != null)
        {
            DataSession.Instance.User = user;
            DataSession.Instance.User.IsAuthenticated = true; // Set IsAuthenticated to true for a successful login
            Console.WriteLine(DataSession.Instance.User.Uid);
        }

        return user;
    }


    public async Task<IEnumerable<WorkoutPlan>> GetWpByUserID(int id)
    {
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/LogIn/{id}");
        response.EnsureSuccessStatusCode();

        string message = await response.Content.ReadAsStringAsync();
        IEnumerable<WorkoutPlan> result = JsonSerializer.Deserialize<List<WorkoutPlan>>(message);

        return result;
    }

    
  
    
}