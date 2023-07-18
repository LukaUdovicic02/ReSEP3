using System;
using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;
using BlazorT1.Data;
using BlazorT1.Services;

namespace BlazorT1
{

    public class UserApiService : IAuthService
    {
        private readonly HttpClient httpClient;

        public UserApiService(HttpClient httpClient)
        {
            this.httpClient = httpClient;
        }

        public async Task<User> ValidateUser(string username, string password)
        {
            try
            {
                var response =
                    await httpClient.PostAsJsonAsync("api/auth/login",
                        new { Username = username, Password = password });
                response.EnsureSuccessStatusCode();

                return await response.Content.ReadFromJsonAsync<User>();
            }
            catch (Exception ex)
            {
                // Handle exceptions appropriately
                Console.WriteLine($"Error occurred while validating user: {ex.Message}");
                return null;
            }


            public async Task RegisterUser(User user)
            {
                try
                {
                    var response = await httpClient.PostAsJsonAsync("api/auth/register", user);
                    response.EnsureSuccessStatusCode();
                }
                catch (Exception ex)
                {
                    // Handle exceptions appropriately
                    Console.WriteLine($"Error occurred while registering user: {"Can't save this user"}");
                }
            }
        }
    }
}

