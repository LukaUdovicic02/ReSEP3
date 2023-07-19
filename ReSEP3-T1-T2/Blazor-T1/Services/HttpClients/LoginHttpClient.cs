using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Model;

public class LoginHttpClient : ILoginService
{
    private readonly HttpClient httpClient;

    public LoginHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task<User> Login(string username, string password)
    {
        HttpResponseMessage response = await httpClient.GetAsync($"http://localhost:5052/LogIn/{username}/{password}");
        response.EnsureSuccessStatusCode(); // This will throw an exception for non-success status codes.

        User user = await response.Content.ReadFromJsonAsync<User>(new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        });

        return user;
    }
}