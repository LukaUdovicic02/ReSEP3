using System;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Model;

public class RegisterHttpClient : IRegisterService
{
    private readonly HttpClient httpClient;

    public RegisterHttpClient(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }
    public async Task Register(User user)
    {
        
        string userAsJson = JsonSerializer.Serialize(user);
        StringContent content = new StringContent(
            userAsJson,
            Encoding.UTF8,
            "application/json"
        );
        HttpResponseMessage response = await httpClient.PostAsync("http://localhost:5052/LogIn/", content).ConfigureAwait(false);
        if(!response.IsSuccessStatusCode)
            throw new Exception(@"Error: {responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");


    }
}