using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using Blazor;
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
        HttpClientHandler clientHandler = new HttpClientHandler();
        clientHandler.ServerCertificateCustomValidationCallback = (sender, cert, chain, sslPolicyErrors) => { return true; };
        clientHandler.ServerCertificateCustomValidationCallback = HttpClientHandler.DangerousAcceptAnyServerCertificateValidator;
            
        using HttpClient client = new HttpClient(clientHandler);
            
            
        client.DefaultRequestHeaders.Accept.Clear();
        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/vnd.github.v3+json"));
        client.DefaultRequestHeaders.Add("User-Agent",".NET Foundation Repository Reporter");
            
            
        HttpResponseMessage response = await client.GetAsync($"http://localhost:5052/LogIn/{username}/{password}").ConfigureAwait(false);
        if (!response.IsSuccessStatusCode)
            return null;
            
        string result = await response.Content.ReadAsStringAsync().ConfigureAwait(false);

        if (result.Equals("")) return null;
        User user = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        });

        return user;

    }
    
    

}
