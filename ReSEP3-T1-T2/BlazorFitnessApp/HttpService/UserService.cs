using System.Net;
using System.Text.Json;
using BlazorApp1.Data;

namespace BlazorApp1.HttpService;

public class UserService
{
   
        public async Task<User> ValidateLogin(string username, string password)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage response = await client.GetAsync($"http://localhost:5052/users?username={username}&password={password}");
            if (response.StatusCode == HttpStatusCode.OK)
            {
                string userAsJson = await response.Content.ReadAsStringAsync();
                User resultUser = JsonSerializer.Deserialize<User>(userAsJson);
                return resultUser;
            } 
            throw new Exception("User not found");
        }
}