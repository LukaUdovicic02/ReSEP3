using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using Model;

namespace Blazor;

public class RegisterHttpClient : IRegisterService
{
    private readonly HttpClient httpClient;

    public RegisterHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }
    public async Task<bool> Register(User user)
    {
        HttpClientHandler clientHandler = new HttpClientHandler();
        clientHandler.ServerCertificateCustomValidationCallback = (sender, cert, chain, sslPolicyErrors) => { return true; };

        using HttpClient client = new HttpClient(clientHandler);
            
            
        client.DefaultRequestHeaders.Accept.Clear();
        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/vnd.github.v3+json"));
        client.DefaultRequestHeaders.Add("User-Agent",".NET Foundation Repository Reporter");
            
            
        string userAsJson = JsonSerializer.Serialize(user);
        StringContent content = new StringContent(
            userAsJson,
            Encoding.UTF8,
            "application/json"
        );
        HttpResponseMessage response = await client.PostAsync("http://localhost:5052/LogIn/", content).ConfigureAwait(false);
        if(!response.IsSuccessStatusCode)
            throw new Exception(@"Error: {responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");

        return true;
    }
}