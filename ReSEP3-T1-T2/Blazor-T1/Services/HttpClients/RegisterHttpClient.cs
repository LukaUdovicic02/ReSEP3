using System;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Model;

public class RegisterHttpClient : IRegisterService
{
    private readonly HttpClient httpClient;

    public RegisterHttpClient()
    {
        this.httpClient = new HttpClient();
    }

    public async Task<User> Register(User user)
    {
        // plan.UserID = DataSession.Instance.User.Uid;
        User sendUser = new(user.Username, user.Password);
        HttpResponseMessage response = await httpClient.PostAsJsonAsync("http://localhost:5052/LogIn", sendUser);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        User u = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        })!;

        return u;
    }
}